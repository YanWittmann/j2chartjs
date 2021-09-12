# Examples

<details>
  <summary>Line chart with multiple lines and entries</summary>

Setting the interaction mode to index will show all entries on the current index on hover.
```Java
LineChartDataset shoes = new LineChartDataset()
    .setData(10, 20, 15, 23, 9, 2)
    .setBorderColor(ChartColors.BORDER_RED)
    .setBackgroundColor(ChartColors.BACKGROUND_RED)
    .setTension(0.2)
    .setLabel("Shoes");
LineChartDataset tShirts = new LineChartDataset()
    .setData(17, 23, 5, 2, 6, 22)
    .setBorderColor(ChartColors.BORDER_ORANGE)
    .setBackgroundColor(ChartColors.BACKGROUND_ORANGE)
    .setTension(0.3)
    .setLabel("T-Shirts");

LineChartData barChartData = new LineChartData()
    .addLabels("Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6")
    .addDataset(shoes)
    .addDataset(tShirts);

ChartOptions chartOptions = new ChartOptions()
    .setInteraction(new InteractionOption()
        .setMode("index"))
    .setTitle(new TitleOption()
        .setText("# Items sold")
        .setDisplay(true));

LineChart lineChart = new LineChart()
    .setChartOptions(chartOptions)
    .setChartData(barChartData);
```
</details>

<details>
  <summary></summary>

n
```Java

```
</details>