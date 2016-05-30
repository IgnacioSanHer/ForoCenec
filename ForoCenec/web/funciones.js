/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function repitePassword(){
    objeto_pwd=document.getElementById("passwordRegistrarse");
    objeto_pwdRepe=document.getElementById("passwordRepe");
    boton=document.getElementById("registrarse");
    valor_pwd=objeto_pwd.value;
    valor_pwdRepe=objeto_pwdRepe.value;
    if(valor_pwd!=valor_pwdRepe){
       document.getElementById("registrarse").disabled=true; 
    }
    else
    {
        document.getElementById("registrarse").disabled=false; 
    }
}

