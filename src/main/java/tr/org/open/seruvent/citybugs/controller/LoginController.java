package tr.org.open.seruvent.citybugs.controller;

import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tr.org.open.seruvent.citybugs.model.AuthRequest;
import tr.org.open.seruvent.citybugs.model.JwtResponse;
import tr.org.open.seruvent.citybugs.service.UserService;
import tr.org.open.seruvent.citybugs.util.JWTTokenUtil;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    private tr.org.open.seruvent.citybugs.model.User user;

    /**
     * @desc -> Gelen request içerisinden access token alınır. RequestBody için AuthRequest class'ı oluşturulmuştur.
     *          Access token ile ilgili uygulama üzerinden kullanıcı verileri çekilerek JWT formatında datanın dönmesi
     *          sağlanır.
     *
     *       -> Birden fazla User objesi olduğundan tr.org.open.seruvent.citybugs.model.User özellikle belirtilmiştir
     *
     * @param authenticationRequest
     * @return
     */
    @RequestMapping(method=RequestMethod.POST  , value="/authenticate")
    public ResponseEntity<?> login(@RequestBody AuthRequest authenticationRequest){

        // -1- Facebook Client objesi oluşturulur (RequestBody üzerinden alınan access token ile)
        DefaultFacebookClient deviceTokenClient = new DefaultFacebookClient(authenticationRequest.getAccessToken(), Version.LATEST);

        // -2- Facebook üzerinden kullanıcı bilgileri fetch edilir
        User facebookUser = deviceTokenClient.fetchObject("me", User.class, Parameter.with("fields", "id,first_name,last_name,email"));

        // -3- Kullanıcı hizmet içerisinde kayıtlı değilse kaydedilir
        user = userService.getUserByEmail(facebookUser.getEmail());
        if(user==null){
            user = new tr.org.open.seruvent.citybugs.model.User(
                    facebookUser.getEmail(),
                    facebookUser.getEmail(),
                    facebookUser.getFirstName(),
                    facebookUser.getLastName()
            );

            user.setFacebook_id(facebookUser.getId());
            user.setFacebook_access_token(authenticationRequest.getAccessToken());
            user.setRandomPassword();
            userService.addUser(user ,2);
        }

        // -4- Kullanıcı username değeri ile JWT döndürülür
        String token = jwtTokenUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
