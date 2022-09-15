/**
 * 
 */
const nbAleatoire = getRandomArbitrary();
var nbTentative=0;
var trouver =false;
var tabChoix = [];


// On renvoie un nombre aléatoire entre une valeur min (incluse)
// et une valeur max (exclue)
function getRandomArbitrary() 
{
	return Math.floor(Math.random() * 100) + 1;
}
//reset la page
function refreshPage() 
{
	window.location.reload();
}


function getInfoFormulaire() 
{
	
	nbTentative++;
	if (nbTentative <= 3) 
	{
		
		var nbchoix = parseInt(document.getElementById("nbchoix").value);
		tabChoix.push(nbchoix);
		var nbtentative= document.getElementById("nbtentative");
		var nberreur= document.getElementById("nberreur");
		var e = document.getElementById("msgerreur");
    	
		if ((nbchoix > nbAleatoire)&& nbTentative!=3)  
		{

			nberreur.innerHTML = "le nombre est plus petit ";
			nbtentative.innerHTML = nbTentative;
			e.style.visibility = 'visible';
			
		} else if ((nbchoix < nbAleatoire)&& nbTentative!=3) 
		{
			nberreur.innerHTML = "le nombre est plus grand ";
			nbtentative.innerHTML = nbTentative;
			e.style.visibility = 'visible';
		}
		else if (((nbchoix == nbAleatoire)&& nbTentative==3) || (nbchoix == nbAleatoire) ) 
		{
			//appel ajax pour retourner la page historique
			trouver=true;
			getPageHistorique(tabChoix,nbAleatoire,trouver);
			
		}else if (nbTentative==3) 
		{
			//appel ajax pour retourner la page historique
			getPageHistorique(tabChoix,nbAleatoire,trouver);
		}
	}

}
function getPageHistorique(p_tabChoix,p_nbAleatoire,p_trouver)
{
	 

	 let dataHistorique =
	 		{
                choix1: p_tabChoix[0],
                choix2: p_tabChoix[1],
                choix3: p_tabChoix[2],
                v_nbAleatoire : p_nbAleatoire,
                v_trouver:p_trouver
            }
      let jsonData = JSON.stringify(dataHistorique);
           // alert(jsonData);
 

            
 $.ajax({
	    //dataType: 'json',
        contentType: "application/json",
        dataType: "html",
        type: "POST",
        url: "http://localhost:8082/jeux_historiqe",
        data: jsonData,

        success: function(data, textStatus, jqXHR) 
        {
	    //parsing to json
	    let jsonDataResult = JSON.parse(data);
		//afficher le modal selon le nombre de tentative
		if(nbTentative<3)
		{
			modalAvecMoinsTroisTentative(jsonDataResult);
		}else if(nbTentative==3)
		{
			modalAvecTroisTentative(jsonDataResult)
		}

        },
        error: function(jqXHR, textStatus, errorThrown) {  

			//alert(jqXHR.responseText);
            //$("#result").html(jqXHR.responseText);
           // console.log("ERROR : ", jqXHR.responseText);
           // $("#submitButton").prop("disabled", false);

        }
    });
	
}
function modalAvecTroisTentative(jsonDataResult)
{
	
		 document.getElementById("choix1").innerHTML=jsonDataResult.choix1;
		 document.getElementById("choix2").innerHTML=jsonDataResult.choix2;
		 document.getElementById("choix3").innerHTML=jsonDataResult.choix3;
		 document.getElementById("nbATrouver").innerHTML=jsonDataResult.nombre_a_trouver;
		
		displayModal("#simpleModal");
}
function modalAvecMoinsTroisTentative(jsonDataResult)
{
			if(nbTentative==1)
			{
				document.getElementById("choix1MoinsTroisTentative").innerHTML=jsonDataResult.choix1;
				//cacher les div avec le choi 2 et 3
				$('#divchoix2MoinsTroisTentative').hide();
				$('#divchoix3MoinsTroisTentative').hide();
			}else if(nbTentative==2)
			{
				document.getElementById("choix1MoinsTroisTentative").innerHTML=jsonDataResult.choix1;
				document.getElementById("choix2MoinsTroisTentative").innerHTML=jsonDataResult.choix2;
				//cacher les div avec le choi  3
				$('#divchoix3MoinsTroisTentative').hide();
			}
		 
		 document.getElementById("nbATrouverMoinsTroisTentative").innerHTML=jsonDataResult.nombre_a_trouver;
		displayModal("#simpleModal2MoinsTroisTentative");
		
}

function displayModal(divsimpleModal)
{

	
	$(divsimpleModal).modal('show');
		//desactiver le bacgroud lorsque le modal est ouvert
		$(divsimpleModal).on('hide.bs.modal', function(e) {

       		e.preventDefault();
   		});
}
