package dto;

public class UsuarioDTO {
    public int id;
    public String name;
    public String username;
    public String email;
    public DireccionDTO address;
    public String phone;
    public String website;
    public CompañiaDTO company;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DireccionDTO getAddress() {
        return address;
    }

    public void setAddress(DireccionDTO address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public CompañiaDTO getCompany() {
        return company;
    }

    public void setCompany(CompañiaDTO company) {
        this.company = company;
    }
}

