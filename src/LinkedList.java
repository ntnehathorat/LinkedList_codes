public class LinkedList {
    Node head;
    Node tail;
    int size;

   public void  addLast(int val)
    {
         Node temp = new Node();
         temp.data = val;
         temp.next = null;

         if(size == 0)
         {
             head = tail = temp;
         }
         else
         {
            tail.next = temp;
            tail= temp;
         }
         size++;
    }

    public int size()
    {
        return size;
    }

    public  void  display()
    {
        Node temp = head;
        while( temp != null)
        {
            System.out.print(temp.data +" ");
        }
        System.out.println();
    }

    public void removeFirst()
    {
        if(size == 0)
      {
        System.out.println("list is empty");
      }
        else if (size == 1)
        {
            head =tail = null;
            size =0;
        }
        else
        {
            head = head.next;
            size--;
        }
    }

    public int getFirst()
    {
       if(size == 0)
       {
           System.out.println("List Is Empty");
           return -1;
       }
       return head.data;
    }
    public  int getLast()
    {
        if(size == 0)
        {
            System.out.println("List Is Empty");
            return -1;
        }
        return tail.data;
    }
    public int getAt(int index)
    {
        if(size == 0)
        {
            System.out.println("List Is Empty");
            return -1;
        }
        else if(index < 0 || index >= size)
        {
            System.out.println("Invalid arguments");
            return -1;
        }
        else
        {
          Node temp = head;
          for(int i=0; i<index ; i++)
          {
             temp = temp.next;
          }
          return temp.data;
        }

    }

    public void addFirst(int val)
    {
       Node temp = new Node();
       temp.data = val;
       temp.next = head;
       head = temp;
       if(size == 0)
       {
           tail = temp;
       }
       size++;
    }

    public void addAt(int index , int val)
    {
        if(index < 0 || index > size)
        {
            System.out.println("Invalid Arguments");
        }
        else if (index ==0)
        { //addfirst
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
              if(size == 0)
              {
                tail = temp;
              }
            size++;
        }
        else if (index == size)
        { //addlast
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
              if(size == 0)
              {
                head = tail = temp;
              }
              else
              {
                tail.next = temp;
                tail = temp;
              }
            size++;
        }
        else
        {
           Node treeNode = new Node();
           treeNode.data = val;
           Node temp = head;
           for(int i=0; i<index-1; i++)
           {
               temp = temp.next;
           }
           treeNode.next = temp.next;
           temp.next = treeNode;
           size++;
        }
    }

    public  void  removeLast()
    {
        if(size == 0)
        {
            System.out.println("List os empty");
        }
        else if (size == 1)
        {
            head = tail = null;
            size =0;
        }
        else
        {
           Node temp = head;
           for(int i=0; i< size-2 ; i++)
           {
               temp = temp.next;
           }
           tail = temp;
           temp.next= null;
           size--;
        }
    }

    private Node getNodeAt(int index)
    {
        Node temp = head;
        for(int i=0; i<index; i++ )
        {
            temp = temp.next;
        }
        return  temp;
    }
    public void reverseDI()
    {
      int li = 0;
      int ri = size-1;

      while (li<ri)
      {
          Node left = getNodeAt(li);
          Node right = getNodeAt(ri);

          int temp = left.data;
          left.data = right.data;
          right.data = temp;

          li++;
          ri--;
      }
    }

    public void reversePI()
    {
        Node prev = null;
        Node curr = head;

        while(curr != null)
        {   Node nextPointer = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPointer;
        }

        //swapping head and tail

        Node temp = head;
        head = tail;
        tail = temp;
    }


    public void removeAt(int index)
    {
       if (index < 0 || index > size) //--//
       {
         System.out.println("Invalid Arguments");
       }
       else if (index == 0 ) //--//
       {
           // removefirst

           if(size == 0)
           {
               System.out.println("list is empty");
           }
           else if (size == 1)
           {
               head =tail = null;
               size =0;
           }
           else
           {
               head = head.next;
               size--;
           }
       }
       else  if(index == size-1) //--//
       {
           // removelast

           if(size == 0)
           {
               System.out.println("list is empty");
           }
           else if (size == 1)
           {
               head =tail = null;
               size =0;
           }
           else
           {
               Node temp = head;
               for(int i=0; i<size-2; i++)
               {
                   temp = temp.next;
               }
               tail = temp;
               temp.next = null;
               size--;
           }
       }
       else
       {
         Node temp = head;
         for(int i =0; i<index-1; i++)
         {
             temp = temp.next;
         }
         temp.next = temp.next.next;
         size--;
       }
    }

    public int kthFromLast(int k)
    {
        //  use -iteration , single traversal : not use - size
       //two pointer
        Node slow = head;
        Node fast = head;

        for(int i=0; i<k ; i++)
        {
            fast = fast.next;
        }

        while(fast != tail)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public  int mid()
    {
        //  use -iteration , single traversal : not use - size
        //two pointer
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null)
        {
           slow= slow.next;
           fast = fast.next.next;
        }
        return slow.data;
    }

    public static LinkedList mergeTwoSortedList(LinkedList l1, LinkedList l2)
    {
        Node one = l1.head;
        Node two = l2.head;

        LinkedList result = new LinkedList();

        while(one != null && two != null)
        {
            if(one.data < two.data)
            {
                result.addLast(one.data);
                one = one.next;
            }
            else
            {
                result.addLast(two.data);
                two= two.next;
            }
        }

        while (one != null)
        {
            result.addLast(one.data);
            one = one.next;
        }

        while (two != null)
        {
            result.addLast(two.data);
        }
        return result;
    }

    // 2-7-1-6-5-3-2-4-3 merge sort ll

    public static Node midNode(Node head, Node tail )
    {
        Node slow = head;
        Node fast = head;

        while (fast != tail && fast.next != tail)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static LinkedList mergeSort(Node head, Node tail)
    {   //2-2,7-7
        if(head == tail)
      {
        LinkedList baseResult = new LinkedList();
        baseResult.addLast(head.data);
        return baseResult;
      }

        Node mid = midNode(head,tail);
        LinkedList fsh = mergeSort(head,mid);
        LinkedList ssh = mergeSort(mid.next,tail);
        //mergeTwoSortedList
        LinkedList completeList = LinkedList.mergeTwoSortedList(fsh,ssh);

        return completeList;
    }

    //2-2-2-2-3-3-3-5-5-5 = 2-3-5
    public  void removeDuplicates()
    {
        LinkedList result = new LinkedList();

      while (this.size() > 0)
      {  // 39,57
          int val = this.getFirst(); // head.data
          this.removeFirst(); //head.next

          if (result.size() == 0 || result.tail.data != val) {
              result.addLast(val);
          }
      }
      this.head = result.head;
      this.tail = result.tail;
      this.size = result.size;
    }

    // first-->odd last--> even + maintain relative order

     public void oddEven()
     {
         LinkedList odd = new LinkedList();
         LinkedList even = new LinkedList();

         while (this.size > 0)
         {
             int val = this.getFirst();
             this.removeFirst();;

             if(val % 2 == 0)
             {
                 even.addLast(val);
             }
             else
             {
                 odd.addLast(val);
             }
         }

         odd.tail.next = even.head; // joining both ll
         this.head = odd.head;
         this.tail = even.tail;
         this.size = odd.size + even.size;

     }

     // k reverse

    public void kReverse(int k)  //***//
    {
        LinkedList prev = null;

        while (this.size > 0) {
            LinkedList curr = new LinkedList();

            if (this.size >= k) {
                for (int i = 0; i < k; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addFirst(val);
                }
            } else {
                int sz = this.size;
                for (int i = 0; i < sz; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addLast(val);
                }
            }

            if (prev == null) {
                prev = curr;
            } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size;
            }
        }

        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;
    }

    // display reverse recurssively

    public void displayReverseHelp(Node node)
    {
        if(node == null)
        {
            return;
        }

        displayReverseHelp(node.next);
        System.out.print(node.data +" ");
    }
    public void displayReverse()
    {
        displayReverseHelp(head);
        System.out.println();
    }

    // reverse ll pointer Recursive
 public void reversePRHelper(Node node)
 {
     if(node == null)
  {
     return;
  }
     reversePRHelper(node.next);
     if(node == tail)
     {
         //nothing to do here
     }
     else
     {
         node.next.next = node;
     }
 }

 public  void reversePR()
 {
     reversePRHelper(head);
     head.next = null;
     Node temp = head;
     head = tail;
     tail = temp;
 }

    // reverse ll Data Recursive
    public void reverseDRHelper(Node right, int floor)
    {
       if(right == null)
       {
           return;
       }
       reverseDRHelper(right.next, floor + 1);

       if(floor >= size/2)
       {
           int temp = right.data;
           right.data = rleft.data;
           rleft.data = temp;

           rleft = rleft.next;
       }
    }
   Node rleft;
    public void reverseDR()
  {
      rleft =head;
      reverseDRHelper(head,0);
  }

  // is linkedlist is palindrome

    private boolean IsPalindromeHelper(Node right)
    {
        if(right == null)
        {
            return true;
        }
        boolean rres = IsPalindromeHelper(right.next);
        if( rres == false) // extrems
        {
            return false;
        }
        else if (right.data != pleft.data)
        {
            return false;
        }
        else
        {
            pleft = pleft.next;
            return  true;
        }

    }
    Node pleft;
     public boolean IsPalindrome()
     {
         pleft = head;
         return IsPalindromeHelper(head);
     }

     //fold ll
    private void foldHelper(Node right, int floor)
    {
      if(right == null)
      {
          return;
      }
      foldHelper(right.next,floor+1);
      //chakali
        if(floor > size/2)
        {
            Node temp = fleft.next;
            fleft.next = right;
            right.next = temp;
            fleft = temp;
        }
        else if (floor == size/2)
        {
           tail = right;
           tail.next = null;
        }
    }
    Node fleft;
    public void fold()
    {
         fleft = head;
         foldHelper(head, 0);

    }

    // add two ll

    private static int addhelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
        if (one == null && two == null) {
            return 0;

        }
        int sum = 0;
        if (pv1 > pv2) {
            int oc = addhelper(one.next, pv1 - 1, two, pv2, res); //pv1=place value of 1
            sum = one.data + oc;
        }
        else if (pv2 > pv1) {
            int oc = addhelper(one, pv1, two.next, pv2 - 1, res); //pv2=place value of 2
            sum = two.data + oc;
        }
        else {
            int oc = addhelper(one.next, pv1 - 1, two.next, pv2 - 1, res); //oc= old carry
            sum = one.data + two.data + oc;
        }

        int c = sum / 10;   //new carry
        int d = sum % 10;   //new digit of "res"
        res.addFirst(d);
        return c;

    }
    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList res = new LinkedList();
        int oc = addhelper(one.head, one.size, two.head, two.size, res);
        if (oc > 0) {
            res.addFirst(oc);
        }
        return res;
    }

    // intersection point of ll

    public static int findIntersection(LinkedList one, LinkedList two) {
       //1
        Node t1 = one.head;

        Node t2 = two.head;
        int delta = Math.abs(one.size - two.size); //2

        if (one.size > two.size)
          { //3
            for (int i = 0; i < delta; i++)
            {
                t1 = t1.next;
            }
          }
        else
          {
            for (int i = 0; i < delta; i++)
            {
                t2 = t2.next;
            }
          }
        
        while (t1 != t2) { //4
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1.data; //5
    }








}
