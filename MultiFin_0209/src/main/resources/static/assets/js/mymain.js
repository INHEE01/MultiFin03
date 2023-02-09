// 첫 번째 section의 배경색이 어두우면 헤더 글씨 밝게, 밝으면 어둡게
window.addEventListener('load', function(){
    const windowMode = document.querySelectorAll('.section');
    const navbar = document.querySelector('.navbar');

    // if(windowMode[0].classList.contains('bg-soft') || windowMode[0].classList.contains('bg-white')){
    //     navbar.classList.remove('navbar-dark');
    //     navbar.classList.add('navbar-light');
    // }
    if(windowMode[0].classList.contains('bg-dark') || windowMode[0].classList.contains('bg-primary')){
        navbar.classList.remove('navbar-light');
        navbar.classList.add('navbar-dark');
    } else{
        navbar.classList.remove('navbar-dark');
        navbar.classList.add('navbar-light');
    }
});




// Background images for sections
$('[data-background]').each(function () {
  $(this).css('background-image', 'url(' + $(this).attr('data-background') + ')');
});

$('[data-background-inner]').each(function () {
    $(this).find('.inner-bg').css('background-image', 'url(' + $(this).attr('data-background-inner') + ')');
});

$('[data-background-color]').each(function () {
    $(this).css('background-color', $(this).attr('data-background-color'));
});

$('[data-color]').each(function () {
    $(this).css('color', $(this).attr('data-color'));
});


/*stock-graph*/
var KOSPI = document.getElementById('KOSPI').getContext('2d');
var lds=[];
for (var i=0; i<30; i++){lds.push(i);}
var data = {
                    labels : lds,
                    datasets: [
                      {
                        backgroundColor: 'rgba(255,150,150,0.5)',
                        borderColor: 'rgb(255,150,150)',
                        data: [163, 164, 151, 153,143,144,154,156,153,
                          143,135,146,136,138,136,146,149,
                          156,153,156,156,159,149,149,149,139,139,135,
                          135,135,134,130,132,125,122,123,123,123,124,126,125,
                          123,146,148,156,150,151,152,158,156,156,149,
                          156,153,156,150,159,160,159,165,167,165,165,
                         ],
                        lineTension : 0,  
                        fill: origin,
                        borderWidth:1,
                        pointRadius: 0,
                      }
                    ]
            };
    let options_now = {
                        scales: {
                            xAxes: [{
                                display: false,
                            }],
                            yAxes: [{
                                gridLines: {
                                    lineWidth: 0,
                                    color: 'rgb(238, 236, 236)',
                                    },
                                ticks: {
                                    beginAtZero: true,
                                    min: 0
                                }
                            }]
                        },
                        legend: {
                          display: false,
                        }
                }
    var myStock = new Chart(KOSPI, {
                type: 'line',
                data: data,
                borderWidth: 5,
                options: options_now
    });
   





const KOSDAQ = document.getElementById('KOSDAQ').getContext('2d');
const gradientFill2 = KOSDAQ.createLinearGradient(0,0,0,65);
gradientFill2.addColorStop(0, 'rgba(225,116,116,0.5)');
gradientFill2.addColorStop(1, 'rgba(225,255,255,0)');
var KOSDAQ_GRAPH = new Chart(KOSDAQ, {
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
      data: [18,16,17,20,18,17,16,14,18,19,14,18],
      tension: 0.0,
      borderColor: 'rgb(231, 76, 60)',
      backgroundColor: gradientFill2,
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


/*nasdaq*/
const NASDAQ = document.getElementById('NASDAQ').getContext('2d');
const NASDAQ_Fill = NASDAQ.createLinearGradient(0,0,0,65);
NASDAQ_Fill.addColorStop(0, 'rgba(225,116,116,0.5)');
NASDAQ_Fill.addColorStop(1, 'rgba(225,255,255,0)');
var myChart = new Chart(NASDAQ, {
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
      data: [18,16,17,20,18,17,16,14,18,19,14,18],
      tension: 0.0,
      borderColor: 'rgb(231, 76, 60)',
      backgroundColor: NASDAQ_Fill,
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



/*USD*/
const USD = document.getElementById('USD').getContext('2d');
const gradientFill3 = USD.createLinearGradient(0,0,0,50);
gradientFill3.addColorStop(0, 'rgba(52, 152, 219,0.5)');
gradientFill3.addColorStop(1, 'rgba(52, 152, 219,0)');
var myChart = new Chart(USD, {
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
      data: [18,16,17,20,18,17,16,14,18,19,14,11],
      tension: 0.0,
      borderColor: 'rgb(52, 152, 219)',
      backgroundColor: gradientFill3,
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

/*JPY*/
const ctx4 = document.getElementById('JPY').getContext('2d');
const gradientFill4 = ctx4.createLinearGradient(0,0,0,65);
gradientFill4.addColorStop(0, 'rgba(225,116,116,0.5)');
gradientFill4.addColorStop(1, 'rgba(225,255,255,0)');
var myChart = new Chart(ctx4, {
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
      data: [18,16,17,20,18,17,11,12,15,11,13,17],
      tension: 0.0,
      borderColor: 'rgb(231, 76, 60)',
      backgroundColor: gradientFill4,
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
