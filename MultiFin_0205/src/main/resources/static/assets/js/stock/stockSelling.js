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


/*주가 그래프*/
$(document).ready(function() {
  // 빈 차트를 생성한다. 
  var chart = new Chart(document.getElementById("myChart"), {
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
          chart = new Chart(document.getElementById("myChart"), {
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
                  lineTension: 0.1
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
      error: function (xhr, status, error) {
          // 블라블라
      },
      complete: function (data) {
          // 블라블라
      }
  })

});
/*
var context = document
              .getElementById('myChart')
              .getContext('2d');
          var myChart = new Chart(context, {
              type: 'line', // 차트의 형태
              data: { // 차트에 들어갈 데이터
                  labels: [
                      '01/25','01/26','01/27','01/29','01/30','01/31','02/01'
                  ],
                  datasets: [
                      { //데이터
                          fill: true, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                          data: [
                              21,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
                          ],
                          backgroundColor: [
                              'rgba(255, 99, 132, 0.2)',
                              'rgba(54, 162, 235, 0.2)',
                              'rgba(255, 206, 86, 0.2)',
                              'rgba(75, 192, 192, 0.2)',
                              'rgba(153, 102, 255, 0.2)',
                              'rgba(255, 159, 64, 0.2)'
                          ],
                          borderColor: [
                              //경계선 색상
                              'rgba(255, 99, 132, 1)',
                              'rgba(54, 162, 235, 1)',
                              'rgba(255, 206, 86, 1)',
                              'rgba(75, 192, 192, 1)',
                              'rgba(153, 102, 255, 1)',
                              'rgba(255, 159, 64, 1)'
                          ],

                          
                          borderWidth: 1 ,//경계선 굵기
                          lineTension: 0.1//각지게 하기
                      }/* ,
                      {
                          label: 'test2',
                          fill: false,
                          data: [
                              8, 34, 12, 24
                          ],
                          backgroundColor: 'rgb(157, 109, 12)',
                          borderColor: 'rgb(157, 109, 12)'
                      } */
                      /*
                  ]
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
          
*/



/* 주가 돈 */
$(function(){
  $('.selling-amount-able').on('click', function(e) {
    let nomValue = $(".selling-amount-able").attr("value")
    console.log(nomValue);
      var sum = parseInt(nomValue || 0);
      var money= sum*61000;

      $("#selling-able-amount").val(sum);
      $("#total_money").val(money.toLocaleString());
    });
});
