package entity;

import javax.swing.*;

public class student {
    private Long id;
    private Long age;
    private Long klass;
    private Long where;
    private String Familiya;
    private String Name_;
    private String Otchestvo;
    private Boolean Delet;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }
    public void setage(Long age) {
        this.age = age;
    }

    public Long getWhere() {
        return where;
    }
    public void setWhere(Long where) {
        this.where = where;
    }

    public Long getKlass() {
        return klass;
    }
    public void setKlass(Long klass) {
        this.klass = klass;
    }

    public String getFamiliya() {
        return Familiya;
    }
    public void setFamiliya(String familiya) {
        Familiya = familiya;
    }

    public String getName_() {
        return Name_;
    }
    public void setName_(String name_) {
        Name_ = name_;
    }

    public String getOtchestvo() {
        return Otchestvo;
    }
    public void setOtchestvo(String otchestvo) {
        Otchestvo = otchestvo;
    }

    public Boolean getDelet(){return Delet;}
    public void setDelet(Boolean delet) {Delet = delet;}

    public void setId(JTextField idField) {
    }

    public void setage(JTextField ageField) {
    }

    public void setKlass(JTextField classField) {
    }

    public void setWhere(JTextField whereField){
    }

    public void setFamiliya(JTextField lastnameField) {
    }

    public void setName_(JTextField nameField) {
    }

    public void setOtchestvo(JTextField middlenameField) {
    }

    public void setDelet(JTextField deletField){
    }

}