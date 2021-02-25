var tabButtons= document.querySelectorAll(".tabContainer .buttonContainer button");
var tabPanels=  document.querySelectorAll(".tabContainer .tabContentContainer .tabPanel");


function showPanel(panelIndex){
    tabButtons.forEach(function (node){
        node.style.backgroundColor="";
    });

    tabButtons.item(panelIndex).style.backgroundColor="#002aff";


    tabPanels.forEach(function (node){
        node.style.display="none"
    });

    tabPanels[panelIndex].style.display="block";
}


showPanel(0)

