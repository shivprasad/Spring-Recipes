package devicedetection;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shiv on 13/12/14.
 */
@Controller
public class DeviceDetectionController {

    @RequestMapping("/detect-device")
    public @ResponseBody String detect(Device device){

        if(device.isMobile()){
            return "Hello Mobile";
        }
        if(device.isTablet()){
            return "Hello Tablet";
        }
        if(device.isNormal()){
            return "Hello Desktop";
        }

        return "Hello stranger..";
    }
}
