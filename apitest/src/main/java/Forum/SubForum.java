package Forum;

public class SubForum {

    private String subject;

    private String theme;

    private String message;

    public SubForum(){

    }

    public SubForum(String subject, String theme, String message){
        this.subject = subject;
        this.theme = theme;
        this.message = message;
    }

    public String getSubject ()
    {
        return subject;
    }

    public void setSubject (String subject)
    {
        this.subject = subject;
    }

    public String getTheme ()
    {
        return theme;
    }

    public void setTheme (String theme)
    {
        this.theme = theme;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "PojoForumMessages [subject = "+subject+", theme = "+theme+", message = "+message+"]";
    }
}
