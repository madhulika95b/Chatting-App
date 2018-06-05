package chattingapp;
import java.util.LinkedHashMap;
import java.util.Map;

import com.pusher.rest.Pusher;
import com.opensymphony.xwork2.ActionSupport;

public class ChatAction extends ActionSupport{

     private Map<String, String> data = new LinkedHashMap<String, String>();

     private String message, userName, uniqueId;

     public String execute() {

          //Pusher pusher = new Pusher("app_id", "key", "secret");
           Pusher pusher = new Pusher("515204", "a7fc94e0a6a5cb5e67ad", "b5289e4b118409d9c40e");
           pusher.setCluster("us2"); // pusher cluster
           pusher.setEncrypted(true);

           data.put("message", this.getMessage());
           data.put("userName", this.getUserName());
           data.put("uniqueId", this.getUniqueId());

           pusher.trigger("struts-chat", "message", data);

           return "SUCCESS";
      }
     public Map<String, String> getData() {
         return data;
     }

     public void setData(Map<String, String> data) {
        this.data = data;
     }

     public String getUniqueId() {
        return uniqueId;
     }

     public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
      }

      public String getUserName() {
         return userName;
      }

      public void setUserName(String userName) {
         this.userName = userName;
      }

      public String getMessage() {
         return message;
      }

      public void setMessage(String message) {
         this.message = message;
      }
}

