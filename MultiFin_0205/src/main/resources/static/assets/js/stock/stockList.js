
$(document).ready(function(){
	
	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');
        var tab_check = $(this).attr('data-tab')+2;
        var tab_check_second = $(this).attr('data-tab')+3;
        var tab_third = $(this).attr('data-tab')+4;

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
        $('.stock_tab_sub').removeClass('current');
        $('.stock_details').removeClass('current');
        $('.stock_description_detail_container').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
        $("#"+tab_check).addClass('current');
        $("#"+tab_check_second).addClass('current');
        $("#"+tab_third).addClass('current');
	})

});


$(function(){
    if (location.hash == "#tab-2"){
        $('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
        $('.stock_tab_sub').removeClass('current');
        $('.stock_details').removeClass('current');
        $('.stock_description_detail_container').removeClass('current');
        
        var check = $('.tabs').find('li').eq(1);
        var tab_id = $(check).attr('data-tab');
        var tab_check = $(check).attr('data-tab')+2;
        var tab_check_second = $(check).attr('data-tab')+3;
        var tab_third = $(this).attr('data-tab')+4;
        
		$(check).addClass('current');
        $("#"+tab_id).addClass('current');
        $("#"+tab_check).addClass('current');
        $("#"+tab_check_second).addClass('current');
 		$("#"+tab_third).addClass('current');
    } 
})





/*주가 그래프*/
/*kospi */
var KOSPI = document.getElementById('KOSPI').getContext('2d');
var lds=[];
for (var i=0; i<200; i++){lds.push(i);}
var data = {
                    labels : lds,
                    datasets: [
                      {
                        backgroundColor: 'rgba(255,150,150,0.5)',
                        borderColor: 'rgb(255,150,150)',
                        data: [163, 164, 151, 153,143,144,154,156,153,
                          143,146,148,146,135,146,136,138,136,146,149,
                          156,153,156,156,159,149,149,149,139,139,135,
                          135,135,134,130,132,125,122,123,123,123,124,126,125,
                          123,146,148,156,150,151,152,158,156,156,149,
                          156,153,156,150,159,160,159,165,167,165,165,
                          153, 154, 153, 153,143,124,164,156,123,
                          123,156,178,156,145,156,156,178,156,146,189,
                          156,123,156,156,159,159,169,159,165,164,165,
                          160,165,156,165,164,162,160,165,154,153,154,158,156,156,188,
                          178,175,176,175,145,131,143,143,142,140,141,141,142,143,
                          143,143,142,140,141,141,142,143,156,145,145,132,131,130,121,120,121,
                          124,120,120,123,123,124,125,123,124,120,119,118,123,134,125,
                          111,110,119,109,109,108,105,109,108,107,106,106,105,106,105,105,
                          110,115,120,125,125,125,123,123,124,125,123,125,128,129,129,
                          130,130,132,135,135,130,134,135,133],
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
                options: options_now
    });
   
    function Hi2(dds, lds){
            lds.push(lds[lds.length-1]+10);
            updateArr(dds);
    }
    
    
    
/*kosdaq */
$(document).ready(function() {
  // 빈 차트를 생성한다. 
  var chart = new Chart(document.getElementById("KOSDAQ"), {
      type: 'line',
      data: {
          labels: [],
          datasets: [
                      {label: [], data: [],},
                      {label: [], data: [],}
          ],
          borderWidth: 1
      },
      options: {
                  legend: {
                      display: false
                  },
                  responsive: false,
                  scales: {
                      yAxes: [
                          {
                              ticks: {
                                  beginAtZero: true
                              }
                          }
                      ]
                  }
              }
  });

  $.ajax({
      url: URL, 
      type: 'get',
      dataType: 'json',
      success: function (data) {
          
          chart.destroy(); // 기존에 생성한 차트 오브젝트를 없앤다. 
          
          // 수신한 json 타입 데이터를 이용하여 차트를 새로 그린다. 
          chart = new Chart(document.getElementById("KOSDAQ"), {
              type: 'line',
              data: {
                  labels: data[0].label,
                  datasets: [
                      {
                          label: "height",
                          data: data[0].height,
                          borderColor: 'rgba(255, 0, 0, 1)',
                      },
                      {
                          label: "weight",
                          data: data[0].weight,
                          borderColor: 'rgba(0, 50, 255, 1)',
                      }
                  ],
                  borderWidth: 1,
                  lineTension: 0.1,
                  pointRadius: 0,
              },
              options: {
                  legend: {
                      display: false
                  },
                  responsive: false,
                  scales: {
                      yAxes: [
                          {
                              ticks: {
                                  beginAtZero: true
                              }
                          }
                      ]
                  }
              }
          });
      },
  })

});
/*nasdacq*/
$(document).ready(function() {
  // 빈 차트를 생성한다. 
  var chart = new Chart(document.getElementById("NASDAQ"), {
      type: 'line',
      data: {
          labels: [],
          datasets: [
                      {label: [], data: [],},
                      {label: [], data: [],}
          ],
          borderWidth: 1
      },
      options: {
                  legend: {
                      display: false
                  },
                  responsive: false,
                  scales: {
                      yAxes: [
                          {
                              ticks: {
                                  beginAtZero: true
                              }
                          }
                      ]
                  }
              }
  });

  $.ajax({
      url: URL, 
      type: 'get',
      dataType: 'json',
      success: function (data) {
          
          chart.destroy(); // 기존에 생성한 차트 오브젝트를 없앤다. 
          
          // 수신한 json 타입 데이터를 이용하여 차트를 새로 그린다. 
          chart = new Chart(document.getElementById("NASDAQ"), {
              type: 'line',
              data: {
                  labels: data[0].label,
                  datasets: [
                      {
                          label: "height",
                          data: data[0].height,
                          borderColor: 'rgba(255, 0, 0, 1)',
                      },
                      {
                          label: "weight",
                          data: data[0].weight,
                          borderColor: 'rgba(0, 50, 255, 1)',
                      }
                  ],
                  borderWidth: 1,
                  lineTension: 0.1,
                  pointRadius: 0,
              },
              options: {
                  legend: {
                      display: false
                  },
                  responsive: false,
                  scales: {
                      yAxes: [
                          {
                              ticks: {
                                  beginAtZero: true
                              }
                          }
                      ]
                  }
              }
          });
      }
  })
});



/*stock-graph(주가동향)*/
graphItems = document.getElementsByClassName('stock_graph'); // 그래프 개수 가져오기
for(i = 1 ; i <= graphItems.length; i++){ /* 그래프 그릴 부분에 id 붙여주고 하나씩 가져오기 */
    let graphId = '#stock_graph'+i;
    const ctx = document.querySelector(graphId).getContext('2d');
    const gradientFill = ctx.createLinearGradient(0,0,0,150);
    gradientFill.addColorStop(0, 'rgba(225,116,116,0.5)');
    gradientFill.addColorStop(1, 'rgba(225,116,116,0)');
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
                    gridLines: { //Y축 gridLines 지우는 옵션
                        drawBorder: false,
                        display: false,
                    },
                    ticks: {
                        beginAtZero: true,
                        fontSize: 0,
                        fontColor: 'rgba(0,0,0,0)',
                        maxTicksLimit: 5,
                        padding: 25,
                    }
                }]
            },
            tooltips: {
                backgroundColor: '#1e90ff'
            }
        },
        data: {
            labels: ['1', '2', '3', '4', '5', '6', '7'],
            datasets: [{
                data: [15, 13, 14,15,11,15,16,14,18,16,17,20],
                tension: 0.0,
                borderColor: 'rgb(231, 76, 60)',
                backgroundColor: gradientFill,
                borderWidth: 2,
                fill:true,
                pointRadius: 0,
            }]
        },
        axis: {
            y: {
                show: false
            }
        }
    });
}


    