class AbstractFactory {
    /*
        For meat products let's create interface Meat
    */
    interface Meat {
        void print();
    }

    /*
        Let's create classes Chicken and Pork which implement interface Meat.
    */
    static class Chicken implements Meat {
        @Override
        public void print() {
            System.out.println("Create meat Chicken");
        }
    }

    static class Pork implements Meat {
        @Override
        public void print() {
            System.out.println("Create meat Pork");
        }
    }

    /*
        For ingredients for garnish let's create interface Garnish
    */
    interface Garnish {
        void print();
    }

    /*
        Let's create classes Rice and Buckwheat which implement interface Garnish
    */
    static class Rice implements Garnish {
        @Override
        public void print() {
            System.out.println("Create garnish with rice");
        }
    }

    static class Buckwheat implements Garnish {
        @Override
        public void print() {
            System.out.println("Create garnish with buckwheat");
        }
    }

    /*
        Now let's create interface which describes preparation of breakfast
            */
    interface BreakfastFactory {
        Meat createMeat();

        Garnish createGarnish();
    }

    /*
         Now we need to create 2 different factories from the interface BreakfastFactory.
         BreakfastOne will be breakfast with chicken and buckwheat. BreakfastTwo will be with pork and rice.
    */
    static class BreakfastOne implements BreakfastFactory {
        @Override
        public Meat createMeat() {
            return new Chicken();
        }

        @Override
        public Garnish createGarnish() {
            return new Buckwheat();
        }
    }

    static class BreakfastTwo implements BreakfastFactory {
        @Override
        public Meat createMeat() {
            return new Pork();
        }

        @Override
        public Garnish createGarnish() {
            return new Rice();
        }
    }

    /*
        Now let's check that as soon as we create a factory for BreakfastOne will get breakfast with chicken and buckwheat

    */
    public static void main(String[] args) {
        //  Try to replace BreakfastOne() with BreakfastTwo()
        //  You'll see Pork and rice breakfast
        BreakfastFactory breakfastFactory = new BreakfastOne();
        Meat meat = breakfastFactory.createMeat();
        Garnish garnish = breakfastFactory.createGarnish();

        System.out.println("Creating breakfast");
        meat.print();
        garnish.print();
    }
}