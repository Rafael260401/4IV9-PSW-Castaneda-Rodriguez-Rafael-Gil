//vamos a tener que obtener los valores de los input

function problema1(){
    var p1_input = document.querySelector('#p1-input').value;

    /*
    tenemos que identificar el espacio
    tenemos que invertir la cadena
    hola como
    como hola
    */ 

    var p1_array = p1_input.split(' ').reverse();

    //contruir una nueva cadena a partir del array invertido

    //comohola

    var p1_res = '';

    p1_array.forEach(function (palabra, i){
        //si estamos al princio o final de la palabra
        // como hola 
        if(i != 0 || i != p1_array.length) p1_res += ' ';
        p1_res += palabra;
    });

    document.querySelector('#p1-output').textContent = p1_res;
}

function problema2(){
    /*
    Para encontrar el minimo producto escalar entre 2 vectores, tenemos que realizar
    las operaciones correspondientes que son el maximo valor de un vector por
    el minimo vector del otro valor 
    
    */ 

    var p2_x1 = document.querySelector('#p2-x1').value;
    var p2_x2 = document.querySelector('#p2-x2').value;
    var p2_x3 = document.querySelector('#p2-x3').value;
    var p2_x4 = document.querySelector('#p2-x4').value;
    var p2_x5 = document.querySelector('#p2-x5').value;

    var p2_y1 = document.querySelector('#p2-y1').value;
    var p2_y2 = document.querySelector('#p2-y2').value;
    var p2_y3 = document.querySelector('#p2-y3').value;
    var p2_y4 = document.querySelector('#p2-y4').value;
    var p2_y5 = document.querySelector('#p2-y5').value;

    //contruir el vector
    var v1 = [p2_x1, p2_x2, p2_x3, p2_x4, p2_x5];
    var v2 = [p2_y1, p2_y2, p2_y3, p2_y4, p2_y5];

    //ordenar los elementos del vector

    v1 = v1.sort(function (a, b){
        return b-a;
    });

    v2 = v2.sort(function (a, b){
        return b-a;
    });

    //invertir el vector
    v2 = v2.reverse();

    //producto
    var p2_producto = 0;

    for(var i = 0; i < v1.length; i++){
        p2_producto += v1[i]*v2[i];
    }

    document.querySelector('#p2-output').textContent = 'Producto escalar minimo :' + p2_producto;


}

function problema3(){

    var input = document.querySelector('#p3-input').value;
    var arreglo = input.split(',');

    var pocision = "";
    var lnMayor = 0;
    var lsMayor = "";

    for (var i = 0 ; i < arreglo.length ; i++){
        pocision = arreglo[i];

        var lsSalida = Conteo(pocision.replace(" ",""));
        var lasValores = lsSalida.split("|");
        var lnLargo = parseInt(lasValores[0],10);

        if(lnLargo > lnMayor){
            lnMayor = lnLargo;
            lsMayor = lsSalida;
        }


    }


    document.querySelector("#p3-output").textContent = "Palabra con mas caracteres unicos: " + lsMayor;
}


function Conteo(elemento){

    var diccionario = new Dictionary();
    var lsLetras = "";
    var lnCont = 0;

    for (var i = 0 ; i < elemento.length ; i++){

        var caracter = elemento.substr(i,1);
        console.log(caracter);
        console.log(diccionario.has(caracter));
        if(diccionario.has(caracter) == false){
            diccionario.set(caracter,caracter);
            lsLetras += caracter + ",";
            lnCont++;
        }
    }
 
    return lnCont.toString() + "|" + lsLetras;
}
class Dictionary {
    constructor () {
      this.items = {}
    }
    
    has (key) {
      return this.items.hasOwnProperty(key);	
    }
    
    set (key, value) {
      this.items[key] = value;
    }
    
    remove (key) {
      if (this.has(key)) {
        delete this.items[key];
        return true;
      }
  
      return false;
    }
    
    get (key) {
      return this.has(key) ? this.items[key] : undefined;
    }
    
    values () {
      const values = []
      for (let key in this.items) {
        if (this.has(key)) {
          values.push(this.items[key])
        }
      }
      return values
    }
  
    size () {
      return Object.keys(this.items).length
    }
    
    keys () {
      const keys = []
      for (let key in this.items) {
          keys.push(keys)
      }
          return keys
    }
    
    getItems () {
      return this.items
    }
  }

function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado===8)return true;
    var patron=/[A-Z\,]/g;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}