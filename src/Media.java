public class Media {
    private String Id;
    private String Filename;
    private String Filetype;
    private Float Duaration;
    private String Description;
    private String Creator;


    public Media() {
    }

    public Media(String id, String filename, String filetype, Float duaration, String description, String creator) {
        Id = id;
        Filename = filename;
        Filetype = filetype;
        Duaration = duaration;
        Description = description;
        Creator = creator;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public String getFiletype() {
        return Filetype;
    }

    public void setFiletype(String filetype) {
        Filetype = filetype;
    }

    public Float getDuaration() {
        return Duaration;
    }

    public void setDuaration(Float duaration) {
        Duaration = duaration;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    @Override
    public String toString() {
        return "Media{" +
                "Id='" + Id + '\'' +
                ", Filename='" + Filename + '\'' +
                ", Filetype='" + Filetype + '\'' +
                ", Duaration=" + Duaration +
                ", Description='" + Description + '\'' +
                ", Creator='" + Creator + '\'' +
                '}';
    }
}
