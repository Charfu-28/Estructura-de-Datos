#include <cassert>
#include <cstdlib>
#include <iostream>
#include <random>
#include "timer2.hh"
#include <cmath>
//*************************************************************************************
using namespace std;
//*************************************************************************************
template <typename T> class Vector
	{
		private:
		  int sz;
		  int capacity;
		  T *storage;
		  int numResizes;
		  int Remove_resizes;
	  
		public:
	  		Vector() : sz(0), capacity(4), numResizes(0), Remove_resizes(0)
			  {
	    		// Allocates memory for an array of capacity elements.
	    		storage = new T[capacity];
	  		  }
	//*************************************************************************************  
int size() const { return sz; }
//*************************************************************************************
void moveOneRight(int i)
	{
	    for (int j = sz; j > i; j--)
	    storage[j] = storage[j - 1];
	}
//************************************************************************************* 
	void resize()
	{
	    numResizes = numResizes + 1;
	    //int nc = capacity * 1.5;
		//int nc = capacity * 2;
	    //int nc = capacity + 1;
	    int nc = capacity * 1.8;
	    //int nc = capacity * 3;
	    T *ns = new T[nc];
	    for (int i = 0; i < sz; i++)
	      ns[i] = storage[i];
	    delete[] storage;
	    storage = ns;
	    capacity = nc;
    }
//************************************************************************************* 
  void add(int i, const T &x)
    {
	    assert(i >= 0 && i <= sz);
	    if (sz == capacity)
		{
		    // array is full
		    resize();
		}
   
	 	moveOneRight(i);
	    storage[i] = x;
	    sz = sz + 1;  
    }
//*************************************************************************************  
  void RemoveWaste (int x)
  {
	  	 assert (sz>0 && x<sz);  
	     for (x; x<sz; x++)
	  	{
	  		storage [x]= storage [x+1];	
		}
	  	sz = sz-1;
	  	
	  	if ((capacity-sz)*2 >= sz)
	  	{
		    T* BR = new T [sz];
	  	    for (int i=0; i<sz; i++)
	  			{
	  				BR [i]= storage [i];
				}
	  		delete []storage;
	  		storage = BR;
	  		capacity = sz;
	  		Remove_resizes++; 	
		}
	}
//*************************************************************************************
int resizes_remove ()const 
	{
		return Remove_resizes;
	}	 
//*************************REMOVE NAIVE************************************************
  void RemoveNaive (int i)
  { 
  	assert (sz>0 && i<sz);  
    for (i; i<sz; i++)
  	{
  		storage [i]= storage [i+1];	
	}
  	sz = sz-1;
  }
//*************************************************************************************  
T get(int i)
	{
		assert(i >= 0 && i < sz);
	    return storage[i];
	}
//*************************************************************************************
int waste() const { return capacity - sz; }
int resizes() const { return numResizes; }
//*************************************************************************************  
void print ()
	{
		for (int i=0; i<sz; i++)
		{
			std::cout << " " << get (i);
			std:: cout<< std:: endl;	
		}
	}	  
	};
//*************************************************************************************
Vector<int> produce(int s, int l, int u)
	{
		random_device rd;
		mt19937 gen(rd());
		uniform_int_distribution<> dis(l, u);
		Vector<int> result;
		for (int n = 0; n < s; n++) {
		result.add(n,dis(gen));
		}
		return result;
	}
//*************************************************************************************
void arrayInsertion(int n)
	{
		int* a = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = 1;
		}	
	}
//*************************************************************************************
void vectorInsertion(int n)
	{
		Vector<int> a; 
		for(int i = 0; i < n; i++)
		{
			a.add(i,1);
		}
	}
//*********************FUNCION TEST PARA VECTOR ***************************************
long test(int n)
	{
	  Timer f("Vector Insertion");
	  vectorInsertion(n);
	  return f.elapsed();
	}
//*********************FUNCION TEST PARA ARRAY ***************************************
long test2(int n)
	{
	  Timer g("Array Insertion");
	  arrayInsertion(n);
	  return g.elapsed();
	}
//*********************FUNCION PARA EL PROMEDIO **************************************
long mean(Vector<long>& data)
	{
		long sum = 0;
		for (int i = 0; i < data.size(); i++)
		{
			sum += data.get(i);
		}
		return sum / data.size();
	}
//**************FUNCION PARA EL PROMEDIO CON TIPO DE DATO DOBLE************************
long mean_double(Vector<double>& data)
	{
	  	double sum = 0;
	 	for (int i = 0; i < data.size(); i++)
		 {
	  		sum += data.get(i);
	 	 }
	 	return sum / data.size();
	}
//************FUNCION PARA TOMAR TIEMPO AL INGRESAR UNA X CANTIDAD DE DATOS************
unsigned long testAddAgrupado (Vector <int>&rotcev)
	{
		Vector <int> a = produce (5000, 0, 5000000);
		Timer T ("Test add");
		for (int i =0; i<a.size(); i++)
		{
			rotcev.add(a.get(i), 10);
		}
		return T.elapsed();
	}
//***********FUNCION PARA MEDIR EL TIEMPO QUE TARDA CADA DATO INGRESADO*****************
void testAdd (Vector <int>&ForAdd)
	{
		Vector <int> a = produce (100, 0, 5000000);
		Vector <int> RR;
		for (int i =0; i<a.size(); i++)
			{
				cout << a.get(i) << ",";
				long t=0;
			{
			for (int e=0; e<20; e++)
			{
				Timer T ("Test add");
				ForAdd.add(a.get(i),10) ;
				t+= T.elapsed();
			}
			RR.add(i,t/20);
			cout << RR.get(i)<< endl;
			}
			}
	}
//*****************************FUNCION TEST PARA REMOVE*********************************
void testRemove (Vector <int>&ForRemove)
	{
		Vector <int> a = produce (100, 0, 5000000);
		Vector <int> RR;
		for (int i =0; i<a.size(); i++)
		{
			cout << a.get(i) << ",";
			long t=0;
		{
			for (int e=0; e<20; e++)
			{
				Timer T ("Test remove");
				ForRemove.RemoveNaive(a.get(i));
				t+= T.elapsed();
			}
			RR.add(i,t/20);
			cout << RR.get(i)<< endl;
		}
		}
	}
//******************************FUNCION PARA VACIAR EL VECTOR*****************************
void vaciar_vector (Vector<int> &reset)
	{
		int y= reset.size();
		for (int i=0; i<y;i++)
		{
			reset.RemoveNaive(0);
		}
	}
//******************************PRUEBA PARA MEDIR EFICIENCIA******************************
void prueba_eficiencia ()
	{
		Vector <int> z;
		Vector <double> coeficientes;
		int x=1000;
		for (int i=0; i<30; i++)
		{
			for (int a=0; a<x; a++)
			{
				z.add(a, 1);
			}	
			
			double coef = ((0.5 * z.waste()) + (0.5 * z.resizes()));
			coeficientes.add(i, coef);
			coef = 0;	
			//cout << x << "," << z.waste() << "," << z.resizes() << "," << coeficientes.get(i); 
			x+=2000;
			cout  << z.waste()  << " " ;
			z.RemoveWaste(z.size()-1);
			cout << "," << z.waste()  << endl;
			vaciar_vector(z);	
		}
		cout << mean_double(coeficientes)<< endl;
	}
//*************************************MAIN*************************************************
int main ()
	{
		Vector <int> b = produce ( 100, 10000, 5000000);
		Vector <long> VectorTimes;
		Vector <int> rotcev;
		return 0;	
	}
