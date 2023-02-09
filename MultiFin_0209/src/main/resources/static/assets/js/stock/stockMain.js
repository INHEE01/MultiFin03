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






/*stock-graph(주가동향)*/
const ctx = document.getElementById('KOSPI').getContext('2d');
const gradientFill = ctx.createLinearGradient(0,0,0,70);
gradientFill.addColorStop(0, 'rgba(225,116,116,0.5)');
gradientFill.addColorStop(1, 'rgba(225,255,255,0)');
var myChart = new Chart(ctx, {
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
        data: [15, 13, 14,15,11,15,16,14,18,16,17,20],
        tension: 0.0,
        borderColor: 'rgb(231, 76, 60)',
        backgroundColor: gradientFill,
        borderWidth: 2,
        pointRadius:1, //포인터 반경 범위 ,
        fill:true,
        pointBorderColor: "rgba(52, 152, 219,1)",
        pointBackgroundColor: "#fff",
        pointRadius: 0,
    }]
  },
  axis: {
    y: {
        show: false
    }
}
});

/*kosdaq*/
const ctx2 = document.getElementById('KOSDAQ').getContext('2d');
const gradientFill2 = ctx2.createLinearGradient(0,0,0,70);
gradientFill2.addColorStop(0, 'rgba(225,116,116,0.5)');
gradientFill2.addColorStop(1, 'rgba(225,255,255,0)');
var myChart = new Chart(ctx2, {
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

/*USD*/
const ctx3 = document.getElementById('USD').getContext('2d');
const gradientFill3 = ctx3.createLinearGradient(0,0,0,60);
gradientFill3.addColorStop(0, 'rgba(52, 152, 219,0.5)');
gradientFill3.addColorStop(1, 'rgba(52, 152, 219,0)');
var myChart = new Chart(ctx3, {
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
const gradientFill4 = ctx4.createLinearGradient(0,0,0,60);
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