package fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by shiv on 02/01/15.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody String uploadFileInfo(){
        return "You can upload to same url using POST";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String uploadFile(@RequestParam String name, @RequestParam MultipartFile file){
        if(file.isEmpty()) {
            return "Failed to upload file as file is empty";
        }

        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(name)));
            bufferedOutputStream.write(file.getBytes());
            bufferedOutputStream.close();
            return "File uploaded successfully - " + name;
        } catch (IOException e) {
            return "Failed to upload file as - " + e.getMessage();
        }
    }

}
