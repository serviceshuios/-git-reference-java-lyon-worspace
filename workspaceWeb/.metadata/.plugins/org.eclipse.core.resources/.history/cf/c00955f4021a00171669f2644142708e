document.getElementById("gros_titre").innerHTML +=" HTML";
document.getElementById("gros_titre").className="styleTitre";
document.querySelector("a").href="http://wikipedia.org";
document.querySelector("p").className="para1";
document.querySelector("img").src="img/Lighthouse.jpg";

var newPara = document.createElement('p');
newPara.id='nouveau';
var texte = document.createTextNode("Texte inséré!");
newPara.appendChild(texte);
document.body.appendChild(newPara);


var newPara2 = document.createElement('p');
//newPara.id='nouveau';
var texte = document.createTextNode("Texte inséré avant!");
newPara2.appendChild(texte);

var par1=document.querySelector('.para');
document.body.insertBefore(newPara2,par1);

var texteSupprime = document.querySelector("h2");
document.body.removeChild(texteSupprime);

document.querySelector("h3").className="texteAdroite";