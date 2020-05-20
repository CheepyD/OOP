package ua.khpi.oop.hulevych16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheck {
    public static boolean validateText(String text) {
        Pattern p = Pattern.compile("^[a-zA-Z \\W]*");
        Matcher m = p.matcher(text);
        return m.matches();
    }
    public static boolean validateInt(String text ) {
        Pattern p = Pattern.compile("^[0-9]{1,}");
        Matcher m = p.matcher(text);
        return m.matches();
    }

    public static boolean validateAgency(Agency temp){
        boolean isValid = true;
        if(!validateText(temp.getFirmName())){
            isValid = false;
        }
        if(!validateText(temp.getPosition())){
            isValid = false;
        }
        if(!validateText(temp.getCircs())){
            isValid = false;
        }
        if(!validateText(temp.getReqs().getEducation())){
            isValid = false;
        }
        return isValid;
    }
}
