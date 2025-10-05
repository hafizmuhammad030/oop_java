import java.util.Stack;

class A{
    private Stack <String> backStack;
    private Stack <String> forwardStack;
    private String currentPage;
    public A()
    {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = null;

    }

    public void visit(String url){
        if (currentPage != null)
        {
            backStack.push(currentPage);
        }
        currentPage = url;
        forwardStack.clear();
        System.out.println("Visited:" + currentPage);

    }
    public void back()
    {
        if(!backStack.isEmpty())
        {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            System.out.println("System went back to:" + currentPage);
        }
        else{
            System.out.println("No pages in the back history.");
        }


    }

    public void forward(){
        if(!forwardStack.isEmpty())
        {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("Went to forward:" + currentPage);
        }
        else{
            System.out.println("No pages in the forward history.");
        }
    }
    public void showCurrentPage()
    {
        if (currentPage != null )
        {
            System.out.println("Current page:"+ currentPage);
        }
        else{
            System.out.println("No current page is show.");
        }
    }
    public static void main(String[] args) {
        A browser = new A();

        browser.visit("google.com");
        browser.visit("github.com");
        browser.visit("stackoverflow.com");
        browser.back();
        browser.back();
        browser.forward();
        browser.visit("oracle.com");
        browser.forward();
        browser.back();

        browser.showCurrentPage();
    }
}









