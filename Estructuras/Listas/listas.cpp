#include <iostream>
#include <cassert>
#include <cstdlib>

using namespace std;

template <typename T> 

class list {
	
	
	class node {
		private: 
		
		T data;
		node *next;
		
		public: 
		
		node (const T &d): data (d), next (nullptr) {} 
		
		//*********** OBTENER EL SGTE***********
		node* getNext ()
		{
			return next;
		}
		
		//*********************+ CAMBIAR EL SIGUIENTE**********
		void setnext (node *n)
		
		{
			next = n;
		}
		
		//**************** OBTENER DATO DE UN NODO*********
		T getData ()
		
		{
			return data;
		}
	};

private:	
	
int sz;
node *first;
node *last;

public:

list () : sz(0), first (nullptr), last (nullptr){}

int size ()

{
	return sz;
}

// ************ MOVERSE A.........****************************
node* moveTo (int n)

{
	assert (n>= -1 && n<sz);
	node* e = first;
	
	for (int i=1; i<=n; i++)
{
		
	e = e->getNext ();
}

return e;
	
}

// ********************* MOVER UNO ANTES**********
node* moveToOneBefore (int n)

{
	return moveTo (n-1);
	}

bool empty ()

{
	return sz==0;
}
////****************** AÑADIR****************	
node* add (int i, const T& x)
{

node *n = new node (x);

if (i==0)
{
	n -> setnext(first);
	first = n;
	if (empty ())
	{
		
	last = n;
}

}

else

{

node *prev = moveToOneBefore (i);

if (prev==last)
{
last = n;
}

n->setnext(prev -> getNext());
prev->setnext (n);


/*if (prev==last)
{
last = n;
}*/
}

sz++;

 } 
 
//********************** BORRAR UN NODO************

void remove (int i) {
	assert (i>=0 && i<sz);
	
	node *n = moveTo(i);
	node *prev = moveToOneBefore (i);
	
	if (n==first)
	{
		first = n-> getNext();
	}

if (n==last)

{
	last = prev;
}

else

{

prev -> setnext (n -> getNext());
}
	
sz--;	
	
}

// ******************** OBTENER UN DATA*********
T  get (int i) {
assert (i>=0 && i<sz);

if (i==sz-1){
	return last -> getData();
}
	


node *l = moveTo(i);
return l->getData();
}
	
};

int  main ()
{

list <int> a;

a.add (0,10);
a.add (1,18);
a.add (2,15);
a.add (3,12);


cout << a.size()<< endl; 
/*a.add (2,15);*/

a.remove (0);
cout << a.size()<< endl; 

cout << a.get(0)<< endl; 
cout << a.get(1)<< endl; 
cout << a.get(2)<< endl; 



	
return 0;

}
