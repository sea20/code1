package cn.sea.user;

public class User {
    private String id;
    private String name;
    private Boolean selfStudy = false;
    private Boolean coach = false;
    private Boolean basketball = false;
    private Boolean football = false;
    private Boolean tableTennis;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelfStudy() {
        return selfStudy;
    }

    public void setSelfStudy(Boolean selfStudy) {
        this.selfStudy = selfStudy;
    }

    public Boolean getCoach() {
        return coach;
    }

    public void setCoach(Boolean coach) {
        this.coach = coach;
    }

    public Boolean getBasketball() {
        return basketball;
    }

    public void setBasketball(Boolean basketball) {
        this.basketball = basketball;
    }

    public Boolean getFootball() {
        return football;
    }

    public void setFootball(Boolean football) {
        this.football = football;
    }

    public Boolean getTableTennis() {
        return tableTennis;
    }

    public void setTableTennis(Boolean tableTennis) {
        this.tableTennis = tableTennis;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
