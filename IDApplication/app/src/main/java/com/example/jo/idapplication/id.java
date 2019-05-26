package com.example.jo.idapplication;

public class id {
    private String id;
    private String gender;
    private String BD;
    private String City;


    public String getGender() {
        return gender;
    }

    public String getBD() {
        return BD;
    }

    public String getCity() {
        return City;
    }

    public id(String id) {
        this.id = id;
        Gender();
        City();
        BD();
    }

    public void Gender(){
        String data= id.substring(9,13);
        int num=Integer.valueOf(data);
        if (num % 2 == 0){
            gender="female";
        }
        else{
            gender="male";
        }
    }

    public void BD(){
        String year=id.substring(1,3);
        String month =id.substring(3,5);
        String day=id.substring(5,7);

        BD=day+"/"+month+"/"+year;


    }

    public void City(){
        String code = id.substring(7,9);
        switch (code){
            case "01":
                City="cairo";
                break;
            case "02":
                City="Alex";
                break;
            case "25":
                City="Assuit";
                break;
            default:
                City="invalid Code";
                break;
        }
    }


}
