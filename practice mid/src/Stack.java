import java.util.Stack;

 class Book{
     String bookName;
     String authorName;
     double price;

     public Book(double price, String authorName, String bookName) {
         this.price = price;
         this.authorName = authorName;
         this.bookName = bookName;
     }

     public String getBookName() {
         return bookName;
     }

     public String getAuthorName() {
         return authorName;
     }

     public double getPrice() {
         return price;
     }

     @Override
     public String toString() {
         return "Book{" +
                 "bookName='" + bookName + '\'' +
                 ", authorName='" + authorName + '\'' +
                 ", price=" + price +
                 '}';
     }
 }

 class BookStack{
     Stack<Book> stack = new Stack<>();

     void pushBook(String bookName,String authorName, double price){
         stack.push(new Book(price,authorName,bookName));
         System.out.println("Book push in stack:" + bookName + "Author Name:" + authorName + "Price:" + price);
     }

     void popBook()
     {
         if(!stack.isEmpty())
         {
             Book removed = stack.pop();
             System.out.println("Book pooped from stack:" + removed);
         }
         else{
             System.out.println("Stack is empty");
         }
     }

     void peekBook()
     {

         if (!stack.isEmpty()){
             Book top = stack.peek();
             System.out.println("Top book in stack:" + top);
         }
         else{
             System.out.println("Stack is empty");
         }


         }
         void display(){
             System.out.println("Details:");
             for (Book book : stack){
                 System.out.println(book);
             }
         }
 }



