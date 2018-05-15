#include <iostream>
#include <cassert>
#include <cstdlib>
#include <string>

using namespace std;

template <typename T> 

class DLList {

           class nodo {
           	
           	private:
           	T data;
           	nodo *prev;
           	nodo *next;
           	
           	public:
           	nodo (const T &d) : data(d), prev(nullptr), next (nullptr) {
           	}
           	
           	nodo* getNext ()
           	{
           		return next;
			   }
           	void setNext (nodo *n)
           	{
           		next = n;
			   }
			 nodo * getPrev ()
			 {
			 	return prev;
			   }  
           	void setPrev(nodo *n)
           	{
           	//	cout << "hola" << endl;
           		prev = n;
			   }
			 
			 T getData ()
			 {
			 	return data;
			   }  
		   };

private:
	int sz;
	nodo *first;
	nodo *last;
	
public: 	
DLList() : sz(0), first (nullptr), last (nullptr) {}


int size ()
{
	return sz;
}

nodo* MoveToFromTheStart (int n){
assert (n>=-1 && n<sz);

nodo *y = first;

for (int i = 1; i<=n; i++){
	y = y->getNext ();
}

return y;	
	
}



nodo* MoveToFromTheEnd (int n){
	assert (n>=-1 && n<sz);

nodo *y = last;

for (int i= size()-1; i>n; i--){
	y= y ->getPrev();
}
return y;	
}

nodo* MoveOneBeforeS (int n){
	MoveToFromTheStart (n-1);
}

nodo* MoveOneBeforeE(int n){
	MoveToFromTheEnd (n-1);
}

nodo* MoveOneLater (int n){
	MoveToFromTheStart (n+1);
}

bool empty (){
	return sz==0;
}
	 
nodo* add (int i, const T& d ){
	assert(i >= 0 && i <= sz);
	nodo *x = new nodo (d);
	/*if (i==0){
	x -> setNext (first);
	first -> setPrev (x);
	first = x;
	if (empty()){
		last = x;
	}*/
	if( i == 0){
		if(empty()){ 
		first = x; last =x;
		}else{
			x -> setNext (first);
			first -> setPrev (x);
			first = x;
			
		}
	}else if (i==sz){
	nodo *l = last;
	last ->setNext (x);
	x -> setPrev (l);
	last = x;
}
	else if (i<=(sz/2))	{
		nodo *prev = MoveOneBeforeS(i);
		nodo *later = MoveOneLater (i);
		x -> setNext(prev->getNext());
		x -> setPrev(prev);
		later -> setPrev (x);
		x -> setPrev (prev);
		prev -> setNext (x);
		
	}
	
	else if (i>(sz/2)){
		
		nodo *prev = MoveOneBeforeE(i);
		nodo *later = MoveOneLater (i); 
		x -> setNext (prev->getNext());
		later -> setPrev (x);
		x -> setPrev (prev);
		prev -> setNext (x);
	}
	sz++;
}
void remove (int i)

{
	assert (i>=0 && i<sz);
		if (i==0)
		{nodo *n= first;
		 nodo *nxt = n -> getNext();
		  first = nxt;
		  first -> setPrev (nullptr);
		  delete n;
		  
		}
		if (i==sz-1)
		{
			nodo *n= last;
			nodo *z = last -> getPrev();
			z-> setNext(nullptr);
			last = z;
			delete n;
				 }
		else
		{
			
			nodo *n= MoveToFromTheStart (i);
			nodo *prev = n->getPrev();
			nodo *nxt = n -> getNext();
			prev -> setNext(nxt);
			nxt -> setPrev (prev);
			delete n;
				 }		 
				 
				  
		sz--;		 		
	
}
T Get (int i){
	assert (i>=0 && i<sz);	
	if (i<=sz/2){
	nodo * y = MoveToFromTheStart (i);
	return y->getData();
	}else if (i>sz/2){
		nodo *z = MoveToFromTheEnd (i);
		return z ->getData(); 
	}
	
	else if (i==sz-1){
	return last -> getData();
}

else if (i==0){
	return first -> getData();
}
	
	 }	
	 
	 void show(){
	 	nodo *x = first;
	 	while(x!= nullptr){
	 		cout << x->getData() << " ";
	 		x = x->getNext();
		 }
		 cout << endl;
	 } 
};


int main ()

{
DLList <int> a;
 
   a.add(0,1);
   a.add(1,2);
   a.add(2,13);
   a.add(3,15);
   cout << a.size()<< endl;
   
   a.show ();
   a.remove(2);
   a.show();
   cout << a.size()<< endl;
   
	return 0;
}


