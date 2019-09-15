package Forum;

public class PojoUsers
{
    private User[] users;

    public User[] getUsers ()
    {
        return users;
    }

    public void setUsers (User[] users)
    {
        this.users = users;
    }

    @Override
    public String toString()
    {
        return "PojoUsers [users = "+users+"]";
    }
}
