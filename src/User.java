public class User {
    private String Name;
    private Integer Id;

    public User() {
    }

    public User(String name, Integer id) {
        Name = name;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
