/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KonversiSuhu.Konversi.Suhu.Final;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
public class KonversiSuhu {
    private int suhureamur(int suhucelcius){
        int suhureamur = suhucelcius *4/5;
        return suhureamur;
    }
   
    private int suhukelvin(int suhucelcius){
        int suhukelvin = (int) (suhucelcius + 273.15);
        return suhukelvin;
    }
    
     private int suhufahrenheit(int suhucelcius){
        int suhufahrenheit = (suhucelcius*9/5)+32;
        return suhufahrenheit;
    }
    @RequestMapping("/suhu")
    //@ResponseBody
    public String getHasil(HttpServletRequest data, Model datasuhu){
       String getnamasuhu = data.getParameter("namasuhu");
       int getsuhucelcius = Integer.parseInt(data.getParameter("suhucelcius")); 
      
       int suhureamur = suhureamur(getsuhucelcius);
       int suhukelvin = suhukelvin(getsuhucelcius);
       int suhufahrenheit = suhufahrenheit(getsuhucelcius);
       
       datasuhu.addAttribute("suhucelcius", getsuhucelcius);
       datasuhu.addAttribute("suhureamur", suhureamur);
       datasuhu.addAttribute("suhukelvin", suhukelvin);
       datasuhu.addAttribute("suhufahrenheit", suhufahrenheit);
       
       return "tableviewer";
    }
}
