package android.lifeistech.com.litboard;

/**
 * Created by fumiyauchiyama on 2017/07/10.
 */

public class Post {

    String message;
    String userName;

    //からのコンストラクタ
    public Post(){



    }

    public Post(String userName,String message){
        this.userName = userName;
        this.message = message;
    }

    public String getMessage(){return message;}

    public void setMessage(String message){this.message = message;}

    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName = userName;}

}
