/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryCatalogSystem;

public abstract class LibraryItem implements Items{
    private String title, author;
    
    public LibraryItem(String titl, String authr){
        title=titl;
        author=authr; 
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public abstract String getType();

    

    
    
    
}
