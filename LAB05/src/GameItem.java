public class GameItem {


        private String itemName;
        private int[] stat;


        public GameItem(String itemName, int[] stats) {
            this.itemName = itemName;
            this.stat = stats.clone();
        }


        public GameItem shallowCopy() {
            return new GameItem(this.itemName, this.stat);
        }


        public GameItem deepCopy()
        {
            int[] statsCopy = new int[this.stat.length];
            System.arraycopy(this.stat, 0, statsCopy, 0, this.stat.length);
            return new GameItem(this.itemName, statsCopy);
        }

        public String getItemName()
        {
            return itemName;
        }


        public int[] getStats() {
            return stat;
        }


        public void printItem() {
            System.out.print("Item: " + itemName + ", Stats: ");
            for (int stat : stat)
            {
                System.out.print(stat + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {

            int[] initialStats = {120, 40, 75};


            GameItem originalItem = new GameItem("Sword of Valor", initialStats);


            GameItem shallowCopyItem = originalItem.shallowCopy();
            GameItem deepCopyItem = originalItem.deepCopy();


            System.out.println("Original Item:");
            originalItem.printItem();

            System.out.println("Shallow Copy:");
            shallowCopyItem.printItem();

            System.out.println("Deep Copy:");
            deepCopyItem.printItem();


            originalItem.getStats()[0] = 100;
            originalItem.getStats()[1] = 50;


            System.out.println("After modifying the original item stats:");

            System.out.println("Original Item:");
            originalItem.printItem();

            System.out.println("Shallow Copy:");
            shallowCopyItem.printItem();
            System.out.println("Deep Copy:");
            deepCopyItem.printItem();
}
    }

