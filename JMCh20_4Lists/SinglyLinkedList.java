import java.util.Iterator;




/**
 * Implements a singly-linked list.
 * 
 * @author Shree Phadke
 * @version 12/8/18
 * 
 * @author Period - 3
 * @author Assignment - Lists
 * 
 * @author Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;

    private int nodeCount;


    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }


    /**
     * Constructor: creates a list that contains all elements from the array
     * values, in the same order
     * 
     * @param values
     *            array containing all elements for this list
     */
    public SinglyLinkedList( E[] values )
    {
        ListNode<E> tail = null;
        for ( E value : values ) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>( value, null );
            if ( head == null )
                head = node;
            else
                tail.setNext( node );
            tail = node; // update tail
        }

        nodeCount = values.length;
    }


    /**
     * Return true if this list is empty; otherwise returns false.
     * 
     * @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return size() == 0;

    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements in this list.
     */
    public int size()
    {

        return nodeCount;
    }


    /**
     * Returns true if this list contains an Object equal to obj; otherwise
     * returns false.
     * 
     * @return true if this list contains an Object equal to obj
     */
    public boolean contains( Object obj )
    {
        boolean x = true;

        if ( indexOf( obj ) == -1 )
        {
            x = false;
        }

        return x;
    }


    /**
     * Returns the index of the first Object equal to obj; if not found, returns
     * -1.
     * 
     * @param obj
     *            Object to find
     * @return the index of the first Object in equal to obj; if not found,
     *         returns -1.
     */
    public int indexOf( Object obj )
    {
        int i = 0;

        for ( E index : this )
        {
            if ( index.equals( obj ) )
            {
                return i;
            }
            else
            {
                i++;
            }
        }
        return -1;
    }


    /**
     * Adds obj to this collection. Returns true if successful; otherwise
     * returns false.
     * 
     * @param obj
     *            element to add to this collection
     * @return true if successful; otherwise returns false.
     */
    public boolean add( E obj )
    {
        ListNode<E> node = head;
        ListNode<E> nextNode = new ListNode<E>( obj, null );
        boolean x = true;

        if ( isEmpty() )
        {
            head = new ListNode<E>( obj, null );
            nodeCount++;
        }

        else if ( isEmpty() == false )
        {

            while ( node != null )
            {
                if ( node.getNext() == null )
                {
                    node.setNext( nextNode );
                    nodeCount++;
                    return x;
                }
                node = node.getNext();
            }
        }

        return x;
    }


    /**
     * Removes the first element that is equal to obj, if any. Returns true if
     * successful; otherwise returns false.
     * 
     * @param obj
     *            element to remove
     * @return true if successful; otherwise returns false.
     */
    public boolean remove( E obj )
    {
        boolean x = true;

        try
        {
            remove( indexOf( obj ) );

        }

        catch ( Exception ex )
        {
            x = false;
        }

        return x;

    }


    /**
     * Returns the i-th element.
     * 
     * @param i
     *            element to get from the list
     * @return element at index i
     * @throws IndexOutOfBoundsException
     */
    public E get( int i )
    {
        int j = 0;

        for ( E index : this )
        {
            if ( j == i )
            {
                return index;
            }

            else
            {
                j++;
            }
        }
        throw new IndexOutOfBoundsException();

    }


    /**
     * Replaces the i-th element with obj and returns the old value.
     * 
     * @param i
     *            index of element to replace
     * @param obj
     *            replacement element of element at index i
     * @return old value previously located at index i
     * @throws IndexOutOfBoundsException
     */
    public E set( int i, E obj )
    {

        int j = 0;

        for ( E index : this )
        {
            if ( j == i )
            {
                return index;
            }

            else
            {
                j++;
            }
        }
        throw new IndexOutOfBoundsException();

    }


    /**
     * Inserts obj to become the i-th element. Increments the size of the list
     * by one.
     * 
     * @param i
     *            insertion point in list for obj
     * @param obj
     *            element to insert into list
     * @throws IndexOutOfBoundsException
     */
    public void add( int i, E obj )
    {
        ListNode<E> node = head;
        ListNode<E> newNode = new ListNode<E>( obj, head );

        if ( size() > i && i > 0 )
        {
            for ( int j = 1; node != null; j++ )
            {
                if ( j == i )
                {
                    node.setNext( new ListNode<E>( obj, 
                                    node.getNext().getNext() ) );
                    nodeCount++;
                }

                node = node.getNext();
            }
        }
        else if ( i == 0 )
        {
            head = newNode;
            nodeCount++;
        }

        else
        {
            throw new IndexOutOfBoundsException();
        }

    }


    /**
     * Removes the i-th element and returns its value. Decrements the size of
     * the list by one.
     * 
     * @param i
     *            index of element to remove
     * @return element removed from this list
     */
    public E remove( int i )
    {
        E val = head.getValue();

        if ( i >= 0 && i < size() )
        {
            if ( size() == 1 )
            {
                head = null;
                nodeCount = nodeCount - 1;
                return val;
            }

            if ( i == 0 )
            {
                head = head.getNext();
                nodeCount--;
                return val;
            }

            ListNode<E> node = head;
            for ( int n = 0; node.getNext() != null; n++ )
            {
                if ( n == i - 1 )
                {
                    E item = node.getNext().getValue();
                    node.setNext( node.getNext().getNext() );
                    nodeCount--;
                    return item;
                }

                node = node.getNext();
            }
        }

        throw new IndexOutOfBoundsException();
    }


    /**
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        String str = "";

        for ( E index : this )
        {
            str += index.toString() + " ";
        }

        return str;
        
        
    }


    /**
     * Returns an iterator for this collection.
     * 
     * @return an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>( head );
    }
}
