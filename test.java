/*
 * 

Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 

*/

package LibraryCatalogSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int countmag=0,countbook=0,itemCount=0,size=4 ; 
        LibraryItem[] library = new LibraryItem[size]; 
        
        while (true){
            System.out.println("Library Catalog:");  
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Magazine");
            System.out.println("3. Search Items");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            int choice ;
            try{
               choice = in.nextInt();
               if (choice<=0 || choice>4){
                   throw new Exception ();
               }
               in.nextLine();
               
            }catch (IllegalArgumentException|InputMismatchException e) {
                System.out.println("Error: you must enter a number 1-4: ");
                in.nextLine();
                continue; 
                }
            
            try {
                switch (choice){
                    case 1:
                        if (itemCount>= library.length){
                            System.out.println("sorry the library is full");
                            break;
                        }
                        else{
                            try{ 
                                System.out.println("enter book title: ");
                                String title=in.nextLine();
                                if (!title.matches("^([a-zA-Z]+[0-9]*)+(\\s[a-zA-Z]+[0-9]*)*$")) // java1  not java 1
                                    throw new InputMismatchException("Error: book title must be a string & cannot be empty");
                                
                                System.out.println("enter book author: ");
                                String author=in.nextLine();
                                if (!author.matches("^([a-zA-Z]+[0-9]*)+(\\s[a-zA-Z]+[0-9]*)*$"))
                                    throw new InputMismatchException("Error: book author must be a string & cannot be empty");

                                System.out.println("enter book ISBN: ");
                                String isbn=in.nextLine();
                                if (!isbn.matches("^(?!-)[\\d#-]+$"))
                                    throw new InputMismatchException("Error: book ISBN is like 123#456-789 & cannot be empty");                               

                                boolean copies= false;
                                for (int i=0; i<itemCount; i++){
                                    if (
                                        library[i] instanceof Book && ((Book)library[i] ).getISBN().equalsIgnoreCase(isbn)&&
                                        library[i].getType().equalsIgnoreCase("Book") &&
                                        library[i].getTitle().equalsIgnoreCase(title) &&
                                        library[i].getAuthor().equalsIgnoreCase(author)
                                        ){
                                        copies=true;
                                        break;
                                    }
                                }if (copies){
                                        System.out.println("cannot enter two copies of the book");
                                        System.out.println("---------------------");
                                        break;
                                    }
                                
                                library[itemCount++]=new Book(title, author, isbn);
                                countbook ++;
                                System.out.println("The book has been added");
                                System.out.println("items count: "+itemCount+"/"+size);
                                System.out.println("---------------------");
                                break;      
                            }catch (IllegalArgumentException | InputMismatchException e){
                                System.out.println(e.getMessage());
                                //in.nextLine();
                                break;
                            }
                        }  
                    case 2:
                        if (itemCount>= library.length){
                            System.out.println("sorry the library is full");
                            break;
                        }
                        else{  
                           
                            try{ 
                                System.out.println("enter magazin title:");
                                String title=in.nextLine();
                                if (!title.matches("^([a-zA-Z]+[0-9]*)+(\\s[a-zA-Z]+[0-9]*)*$"))
                                    throw new InputMismatchException("Error: magazine title must be a string & cannot be empty");
                                
                                System.out.println("enter magazine author: ");
                                String author =in.nextLine();
                                if (!author.matches("^([a-zA-Z]+[0-9]*)+(\\s[a-zA-Z]+[0-9]*)*$"))
                                    throw new InputMismatchException("Error: magazine author must be a string & cannot be empty");
                                
                                System.out.println("enter magazine issue number: ");
                                int issueNum;
                                try{
                                    issueNum=in.nextInt();
                                     if (issueNum<0)
                                         throw new InputMismatchException();  
                                }catch(IllegalArgumentException|InputMismatchException n){
                                    System.out.println("Error: magazine Issue number must be a Natural Numbers & cannot be empty");
                                    in.nextLine();
                                    break;
                                }
                                
                                boolean copies= false ;
                                for (int i=0; i<itemCount; i++){
                                    if (
                                        library[i] instanceof Magazine &&  ((Magazine) library[i]).getIssueNum()== issueNum&&
                                        library[i].getType().equalsIgnoreCase("magazine") &&
                                        library[i].getTitle().equalsIgnoreCase(title) &&
                                        library[i].getAuthor().equalsIgnoreCase(author)
                                        ){
                                        copies=true;
                                        break;
                                    }  
                                }if(copies){
                                        System.out.println("cannot enter two copies of the magazine");
                                        System.out.println("---------------------");
                                        break;
                                    } 
                                
                                library[itemCount++]= new Magazine (title, author,issueNum);
                                countmag++;
                                System.out.println("The magazine has been added");
                                System.out.println("items count: "+itemCount+"/"+size);
                                System.out.println("---------------------");
                                break;
                                
                            }catch(IllegalArgumentException|InputMismatchException e){
                                System.out.println(e.getMessage());
                                break;
                            } 
                        } 
                        
                    case 3:
                        int search;
                        try{System.out.println("---------------------");
                            System.out.println("search by: ");
                            System.out.println("1. title");
                            System.out.println("2. type");
                            System.out.println("3. author");
                            System.out.println("Choose an option: ");
                            String inp=in.nextLine().trim();;
                            System.out.println("---------------------");
                            try{
                            if (!inp.matches("^[1-3]$"))
                                throw new InputMismatchException("Error: only a number 1-3");
                            search=Integer.parseInt(inp);

                            if (search ==1)
                                System.out.println("enter the title name: ");
                            else if (search ==2)
                                System.out.println("enter the type: ");
                            else if (search ==3)
                                System.out.println("enter the author name: ");
                            }catch (IllegalArgumentException | InputMismatchException e){
                                System.out.println(e.getMessage());
                                break;
                            }
                            String word=in.nextLine().trim();
                            if (!word.matches("^[a-zA-Z0-9\\s]+$"))
                                throw new InputMismatchException("Error: the word must be a string");
                            
                            search(library, itemCount, search, word);
                            break;
 
                        }catch(IllegalArgumentException |InputMismatchException e){
                            System.out.println(e.getMessage()); 
                            break;
                        }
                    case 4:
                        System.out.println("the books you entered are: "+countbook+" and the magazines is: "+countmag);
                        System.out.println("exting program...");
                        return;
                }
            }catch (Exception a){
                System.out.println("there are a big error! try again");
                break;
            }
           
            
        }
    }
    
    public static void displayItem(LibraryItem item){
        if (item instanceof Book){
            System.out.println("---------------------");
            System.out.println("Type is: "+item.getType());
            System.out.println("Title is: "+item.getTitle());
            System.out.println("Author is: "+item.getAuthor());
            System.out.println("ISBN: "+((Book) item).getISBN());
        }
        else if(item instanceof Magazine){
            System.out.println("---------------------");
            System.out.println("Type is:"+ item.getType());
            System.out.println("Title is: " + item.getTitle());
            System.out.println("Author is: " + item.getAuthor());
            System.out.println("Issue Number: " + ((Magazine) item).getIssueNum());
        }
        System.out.println("---------------------");
    }
    
    public static void search(LibraryItem[] library, int itemCount, int search, String word){
        if (itemCount==0){
            System.out.println("the library is empty");
            System.out.println("---------------------");
            return;
        }
        
        boolean find=false;
        for (int i=0; i<itemCount; i++){
            if (search==1 && library[i].getTitle().equalsIgnoreCase(word) ){
                find=true;
                displayItem(library[i]); 
            }
            else if(search ==2 && library[i].getType().equalsIgnoreCase(word)){
                find=true;
                displayItem(library[i]); 
            }
            else if( search==3 && library[i].getAuthor().equalsIgnoreCase(word)){
                find=true;
                displayItem(library[i]);
            }
        }
        if (!find)
            System.out.println("the entered word doesn't match any title or type or author");
        System.out.println("---------------------");
        
        
    }
}
