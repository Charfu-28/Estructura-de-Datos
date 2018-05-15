#include <iostream>
using namespace:: std;
main()
{int cant,contador,a;
cout<<"ingreso numero de lineas"<<endl;
cin>>cant;
if(cant%2==0||cant<3)
{
	cout<<"el rombo no se puede realizar con numeros pares"<<endl;
}
else{
for(contador=0; contador<cant/2; contador=contador+1 )
   {
    for(a=0; a<cant-contador-1; a=a+1 )
     cout<<" ";
    for(a=0; a<2*contador+1; a=a+1)
     cout<<"*";
     cout<<endl;
   } 
for(contador=cant/2; contador>=0; contador=contador-1)
    {
	for(a=0; a<cant-contador-1; a=a+1)
	 cout<<" ";
	for(a=0; a<2*contador+1; a=a+1)
	 cout<<"*";
	 cout<<endl;
    }

}

system("pause");

}

