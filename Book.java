/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryCatalogSystem;

public class Book extends LibraryItem {
    private String isbn;
    
    public Book(String titl, String authr, String ISBN){
        super(titl, authr);
        isbn=ISBN;   
    }
 
    public String getType(){
        return"Book";   
    }
    public String getISBN(){
        return isbn;
    }
    
    
    
            
    
}
