
/*stock-graph(주가동향)*/
const ctx = document.getElementById('KOSPI').getContext('2d');
const gradientFill = ctx.createLinearGradient(0,0,0,80);
gradientFill.addColorStop(0, 'rgba(225,116,116,0.5)');
gradientFill.addColorStop(1, 'rgba(225,255,255,0)');
var lds=[];
//create time span
for (var i=0; i<30; i++){lds.push(i);}
//console.log(lds);
var data = {
            labels : lds,
            datasets: [
              { label: '현재주가',
                spanGaps: true,
			    borderColor: 'rgb(231, 76, 60)',
			    backgroundColor: gradientFill,
			    borderWidth: 2,
			    fill:true,
                lineTension: 0,  
                pointRadius: 0,
                data: [163, 164, 151, 153,143,144,154,156,153,
                  143,146,148,146,135,146,136,138,136,146,149,
                  156,153,156,156,159,149,149,149,139,139,135,
                  135,135,134,130,132,125,122,123,123,123,124,126,125,
                  123,146,148,156,150,151,152,158,156,156,149,
                  156,153,156,150,159,160,159,165,167,165,165,
                  153, 154, 153, 153,143,124,164,156,123,
                  123,156,178,156,145,156,156,178,156,146,189
               ],
                }
            ]
        };
let options = {
                scales: {
                  xAxes: [{
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            fontSize: 0,
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		              
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	},
              plugins: {
                tooltip:{
                  mode:'y',
                  enabled:true,
                  intersect:false
                },
                zoom: {
                  pan: { // 마우스로 잡아서 그래프 이동
                      enabled: true,
                      mode: 'x'
                  },
                  zoom: {
                      wheel: { enabled: true }
                  }
              	}
              },
            }
            
            
            
var myChart = new Chart(ctx, {
        type: 'line',
        data: data,
        options: options
});
   
   
   

/*kosdaq*/
const ctx2 = document.getElementById('KOSDAQ').getContext('2d');
var lds=[];
//create time span
for (var i=0; i<30; i++){lds.push(i);}
//console.log(lds);
var data_KOSDAQ = {
            labels : lds,
            datasets: [
              { label: '현재주가',
                spanGaps: true,
			    borderColor: 'rgb(231, 76, 60)',
			    backgroundColor: gradientFill,
			    borderWidth: 2,
			    fill:true,
                lineTension: 0,  
                pointRadius: 0,
                data: [
                  123,146,151,152,158,156,156,149,110,
                  156,153,156,150,159,160,159,165,167,165,165,
                  153, 154, 153, 153,143,124,164,156,123,
                  123,156,178,156,145,156,156,178,156,146,189
               ],
                }
            ]
        };
let options_KOSDAQ = {
                scales: {
                  xAxes: [{
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            fontSize: 0,
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		              
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	},
              plugins: {
                tooltip:{
                  mode:'y',
                  enabled:true,
                  intersect:false
                },
                zoom: {
                  pan: { // 마우스로 잡아서 그래프 이동
                      enabled: true,
                      mode: 'x'
                  },
                  zoom: {
                      wheel: { enabled: true }
                  }
              	}
              },
            }
            
            
            
var myChart = new Chart(ctx2, {
        type: 'line',
        data: data_KOSDAQ,
        options: options_KOSDAQ
});
   
   
   
   
   
   
   
   
   
   
   

/*USD*/
const ctx3 = document.getElementById('USD').getContext('2d');
var lds=[];
//create time span
for (var i=0; i<30; i++){lds.push(i);}
//console.log(lds);
var data_USD = {
            labels : lds,
            datasets: [
              { label: '현재주가',
                spanGaps: true,
			    borderColor: 'rgb(231, 76, 60)',
			    backgroundColor: gradientFill,
			    borderWidth: 2,
			    fill:true,
                lineTension: 0,  
                pointRadius: 0,
                data: [
                  111,183,156,156,145,155,178,165,145,123,145,144,111,132,131,156,145,189,177,156,
                  156,141,111,123,101,101,98,123,156,148
               ],
                }
            ]
        };
let options_USD = {
                scales: {
                  xAxes: [{
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            fontSize: 0,
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		              
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	},
              plugins: {
                tooltip:{
                  mode:'y',
                  enabled:true,
                  intersect:false
                },
                zoom: {
                  pan: { // 마우스로 잡아서 그래프 이동
                      enabled: true,
                      mode: 'x'
                  },
                  zoom: {
                      wheel: { enabled: true }
                  }
              	}
              },
            }
            
            
            
var myChart = new Chart(ctx3, {
        type: 'line',
        data: data_USD,
        options: options_USD
});
   
   
   
   
   

/*JPY*/
const ctx4 = document.getElementById('JPY').getContext('2d');
var lds=[];
//create time span
for (var i=0; i<30; i++){lds.push(i);}
//console.log(lds);
var data_JPY = {
            labels : lds,
            datasets: [
              { label: '현재주가',
                spanGaps: true,
			    borderColor: 'rgb(231, 76, 60)',
			    backgroundColor: gradientFill,
			    borderWidth: 2,
			    fill:true,
                lineTension: 0,  
                pointRadius: 0,
                data: [
                  156,141,111,123,101,101,98,123,156,148,
                   111,183,156,156,145,155,178,165,145,123,145,144,111,132,131,156,145,189,177,156,
               ],
                }
            ]
        };
let options_JPY = {
                scales: {
                  xAxes: [{
			          gridLines: { //A축 gridLines 지우는 옵션
			            display: false,
			            drawBorder: false,
			          },
			          ticks: {
			            fontSize: 0,
			            fontColor: 'rgba(0,0,0,0)'
			    	    }
		      	 	}],
			        yAxes: [{
			          display: false,
			          gridLines: { //Y축 gridLines 지우는 옵션
			            drawBorder: false,
			            display: false,
			          },
			          ticks: {
			            beginAtZero: true,
			            fontSize: 0,
			          }
		       		}]
		      	},
                legend: {
                  display: false,
              	},
		              
		     	tooltips: {
		       	 	backgroundColor: '#1e90ff'
		      	},
              plugins: {
                tooltip:{
                  mode:'y',
                  enabled:true,
                  intersect:false
                },
                zoom: {
                  pan: { // 마우스로 잡아서 그래프 이동
                      enabled: true,
                      mode: 'x'
                  },
                  zoom: {
                      wheel: { enabled: true }
                  }
              	}
              },
            }
            
            
            
var myChart = new Chart(ctx4, {
        type: 'line',
        data: data_JPY,
        options: options_JPY
});
   







/*SAMSUNG*/
const SAMSUNG = document.getElementById('SAMSUNG').getContext('2d');
const gradientFill_SAMSUNG = SAMSUNG.createLinearGradient(0,0,0,150);
gradientFill_SAMSUNG.addColorStop(0, 'rgba(110, 184, 110,0.5)');
gradientFill_SAMSUNG.addColorStop(1, 'rgba(110, 184, 110,0)');
var myChart = new Chart(SAMSUNG, {
  type: 'line',
    options: {
      legend: {
        display: false,
      },
      scales: {
        xAxes: [{
          gridLines: { //A축 gridLines 지우는 옵션
            display: false,
            drawBorder: false,
          },
          ticks: {
            fontSize: 0,
            fontColor:  'lightgray'
        }

        }],
        yAxes: [{
          display: false,
          gridLines: { //Y축 gridLines 지우는 옵션
            drawBorder: false,
            display: false,
          },
          ticks: {
            beginAtZero: true,
            fontSize: 10,
            fontColor: 'lightgray',
          }
        }]
      },
      tooltips: {
        backgroundColor: '#1e90ff'
      }
    },
    data: {
      labels: ['1', '2', '3', '4', '5', '6', '7','8','9','10','11','12'],
    datasets: [{
      data: [18,16,17,20,18,17,11,12,15,11,13,11],
      tension: 0.0,
      borderColor: 'rgb(110, 184, 110)',
      backgroundColor: gradientFill_SAMSUNG,
      pointRadius:0, //포인터 반경 범위 ,
      borderWidth: 2,
      fill:true,
    }]
  },
  axis: {
    y: {
        show: false
    }
}
});

/*SK*/
const SK = document.getElementById('SK').getContext('2d');
const gradientFill_SK = SK.createLinearGradient(0,0,0,150);
gradientFill_SK.addColorStop(0, 'rgba(110, 184, 110,0.5)');
gradientFill_SK.addColorStop(1, 'rgba(110, 184, 110,0)');
var myChart = new Chart(SK, {
  type: 'line',
    options: {
      legend: {
        display: false,
      },
      scales: {
        xAxes: [{
          gridLines: { //A축 gridLines 지우는 옵션
            display: false,
            drawBorder: false,
          },
          ticks: {
            fontSize: 0,
            fontColor:  'lightgray'
        }

        }],
        yAxes: [{
          display: false,
          gridLines: { //Y축 gridLines 지우는 옵션
            drawBorder: false,
            display: false,
          },
          ticks: {
            beginAtZero: true,
            fontSize: 10,
            fontColor: 'lightgray',
          }
        }]
      },
      tooltips: {
        backgroundColor: '#1e90ff'
      }
    },
    data: {
      labels: ['1', '2', '3', '4', '5', '6', '7','8','9','10','11','12'],
    datasets: [{
      data: [18,16,17,20,18,17,11,12,15,11,13,11],
      tension: 0.0,
      borderColor: 'rgb(110, 184, 110)',
      backgroundColor: gradientFill_SK,
      pointRadius:0, //포인터 반경 범위 ,
      borderWidth: 2,
      fill:true,
    }]
  },
  axis: {
    y: {
        show: false
    }
}
});



/*LG*/
const LG = document.getElementById('LG').getContext('2d');
const gradientFill_LG = LG.createLinearGradient(0,0,0,150);
gradientFill_LG.addColorStop(0, 'rgba(110, 184, 110,0.5)');
gradientFill_LG.addColorStop(1, 'rgba(110, 184, 110,0)');
var myChart = new Chart(LG, {
  type: 'line',
    options: {
      legend: {
        display: false,
      },
      scales: {
        xAxes: [{
          gridLines: { //A축 gridLines 지우는 옵션
            display: false,
            drawBorder: false,
          },
          ticks: {
            fontSize: 0,
            fontColor:  'lightgray'
        }

        }],
        yAxes: [{
          display: false,
          gridLines: { //Y축 gridLines 지우는 옵션
            drawBorder: false,
            display: false,
          },
          ticks: {
            beginAtZero: true,
            fontSize: 10,
            fontColor: 'lightgray',
          }
        }]
      },
      tooltips: {
        backgroundColor: '#1e90ff'
      }
    },
    data: {
      labels: ['1', '2', '3', '4', '5', '6', '7','8','9','10','11','12'],
    datasets: [{
      data: [18,16,17,20,18,17,11,12,15,11,13,11],
      tension: 0.0,
      borderColor: 'rgb(110, 184, 110)',
      backgroundColor: gradientFill_LG,
      pointRadius:0, //포인터 반경 범위 ,
      borderWidth: 2,
      fill:true,
    }]
  },
  axis: {
    y: {
        show: false
    }
}
});