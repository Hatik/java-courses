/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicrunner;

/**
 *
 * @author Admin
 */
public class Cat implements Pet {
    private String name;
    
    public Cat(String name){
    this.name = name;
}

    @Override
    public String getName() {
       return this.name;
    }
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Cate";
    }
    
}
