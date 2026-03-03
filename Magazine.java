/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryCatalogSystem;

public class Magazine extends LibraryItem {
    private int issueNum;

    public Magazine(String titl, String authr,int isueNum){
        super(titl, authr);
        issueNum = isueNum;
    }
    
    public String getType(){
        return "Magazine";
    }
    public int getIssueNum(){
        return issueNum;
    }
    // 
    

}
