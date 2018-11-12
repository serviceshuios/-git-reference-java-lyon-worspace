//1- cibler un élément
var p1 = document.querySelector("p");
//2- ajouter un écouteur d'évènement
p1.addEventListener('mouseover',Fonction1);
function Fonction1(){
	this.innerHTML="Cliquez sur moi maintenant";
	this.style.backgroundColor="orange";
}
p1.addEventListener('mouseout',Reset1);
function Reset1(){
	this.innerHTML="Passer sur moi";
	this.style.backgroundColor="";
}
p1.addEventListener('mousedown',Fonction2);
function Fonction2(){
	this.innerHTML="Bravo !";
	this.className="styledown";
}
p1.addEventListener('mouseup',Reset2);
function Reset2(){
	this.innerHTML="Passer sur moi";
	this.className="styleup";
}