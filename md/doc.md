# Documentation

**j2ChartJs** provides almost every functionality specified in and follows the structure of the
[official ChartJs 3.x documentation](https://www.chartjs.org/docs/latest/).

Also check out the [examples](example.md) after reading through this documentation.

- Creating a chart
  - General Structure
  - Creating Data
  - Collecting the data
  - Specifying more options
  - Creating the chart
- Quick Charts
- Other useful tips & tricks

## Creating a chart
### General structure

The hierarchy of objects is the following:

- Chart
    - Options
    - Data
        - Dataset

### Creating data

Data can be created via datasets of the selected chart type. Every dataset can contain multiple data entries.  
The data type of these entries varies between chart types but is Integer/Double for most of them.  
You can add multiple data entries with the same call by separating them with a `,`. The same can be done with colors and
more.

Example for `BarChart`:

```java
BarChartDataset dataset = new BarChartDataset()
    .setData(12, 32, 8, 45, 27, 23)
    .setBackgroundColor(ChartColors.BACKGROUNDS)
    .addBorderColor(ChartColors.BORDER_RED, ChartColors.BORDER_ORANGE, ChartColors.BORDER_YELLOW);
```

Example for `BubbleChart`:

```java
BubbleChartDataset dataset = new BubbleChartDataset()
  .setLabel("Points in time and space")
  .setBackgroundColor(ChartColors.BACKGROUNDS)
  .setBorderColor(ChartColors.BORDERS)
  .addPointStyle("star");
for(int i = 0; i < 500; i++)
  dataset.addData(new BubbleChartDatapoint(random.nextInt(100),random.nextInt(100),random.nextInt(30)+10));
```

As seen above, the data/options/chart objects can quickly be further configured via chained API calls.

### Collecting the data

Since multiple datasets can be placed on the same chart, they have to be collected in data objects.  
Also, labels for the dataset entries can be specified here.

Example with `DoughnutPieChartData`:

```java
DoughnutPieChartData data = new DoughnutPieChartData()
  .addDataset(dataset1, dataset2)
  .addLabels("First", "Second", "Third");
```

### Specifying more options

A wide variety of options can be set for the charts. The specification for all of them can be found on the
[official ChartJs 3.x documentation](https://www.chartjs.org/docs/latest/configuration/).

Here is a list of the most frequently used ones:

- `options.responsive`  
  The chart will normally automatically use up as much space as available. This might not be the behaviour you are
  intending to use. To disable automatic resizing and rather use the `width` and `height` property of the `canvas`
  element, set `responsive` to `false`.
  ```java
  new ChartOptions().setResponsive(false);
  ```
- `options.interaction.mode`  
  Setting this option to `index` will show all items at the same index on hovering over the data.
  ```java
  new ChartOptions().setInteraction(new InteractionOption().setMode("index"));
  ```
- `options.plugins.title`  
  Setting a title alone will not show it, `display` will have to be set to `true` as well.
  ```java
  new ChartOptions().setTitle(new TitleOption().setText("Sample Chart").setDisplay(true));
  ```
- `options.scales`  
  For modifying existing scales or creating new ones.  
  To create/edit the scale of a dataset, add an `x` or `y` axis identifier to the dataset. This identifier can now be
  used to set all kinds of scale options.  
  Also note that the scale `B` doesn't show the grid via `new ScaleGridOption().setDisplay(false)`.
  ```java
  BarChartDataset dataset1 = new BarChartDataset()
      .setLabel("Week 1")
      .setData(40, 65, 59, 72, 81, 56, 55)
      .setyAxisID("A");
  BarChartDataset dataset2 = new BarChartDataset()
      .setLabel("Week 2")
      .setData(40, 65, 59, 72, 81, 56, 55)
      .setyAxisID("B");
  
  LinearScaleOption linearScaleOptionA = new LinearScaleOption()
      .setType("linear")
      .setPosition("left")
      .setSuggestedMax(100)
      .setGrid(new ScaleGridOption()
          .setDisplay(true)
          .setColor(Color.RED));
  LinearScaleOption linearScaleOptionB = new LinearScaleOption()
      .setType("logarithmic")
      .setPosition("right")
      .setBeginAtZero(false)
      .setTicks(new LinearScaleTicksOption()
          .setColor(Color.BLUE))
      .setGrid(new ScaleGridOption()
          .setDisplay(false));
  
  new ChartOptions()
      .addScale("A", linearScaleOptionA)
      .addScale("B", linearScaleOptionB);
  ```
- `options.animation`  
  There are two different animation types: Chart and property animations.  
  Chart animations affect the initialization animation and property animations can affect various properties of the
  charts.
  ```java
  new ChartOptions()
      .addPropertyAnimation(AnimationProperty.BORDER_WIDTH,
          new PropertyAnimationOption<Integer>()
              .setDuration(10000)
              .setFrom(4)
              .setTo(1))
      .setChartAnimation(new ChartAnimationOption()
          .setDelay(1000)
          .setDuration(4000)
          .setEasing(AnimationEasingType.EASE_IN_OUT_QUART)
          .setLoop(true));
  ```
  You can disable animations all together using `new ChartOptions().setAnimationsActive(false);`.
- `options.transitions`  
  Certain events can also be controlled via animations. These are called `transitions`.  
  This transition would move all data points in a dataset to `0 0` when hiding said dataset:
  ```java
  new ChartOptions().addTransition(TransitionAnimationType.HIDE, new TransitionAnimationOption()
      .addPropertyAnimation(AnimationPropertyOption.X, new PropertyAnimationOption<Integer>().setTo(0))
      .addPropertyAnimation(AnimationPropertyOption.Y, new PropertyAnimationOption<Integer>().setTo(0)));
  ```

### Creating the chart

After setting up the `options` and `dataset` objects, a chart of the same type as the dataset can be passed both
parameters.

Here's an example for a `BarChart`:

```java
BarChart chart = new BarChart()
    .setChartOptions(options)
    .setChartData(data);
  ```

To export the configuration as `JSONObject`, use `.toJson()` on the chart object. This JSON can now be used to
initialize the JS chart:

```JavaScript
var ctx = document.getElementById('canvasId');
new Chart(ctx, jsonChartConfiguration);
```

## Quick Charts

Quick charts allow you to create charts with default configurations so that you can concentrate on what matters:
**Visualizing your data**.

Every chart type has it's `QuickChart` variant. To add data to it, simply use the `addDataset(label, data)`/`addDataset(data)` function.
This will automatically create a dataset with (or without) the given label.  
Use `addLabels(labels)` to add labels to the individual data points.

Here's an example with a bar chart:
```java
new QuickBarChart()
  .addDataset("Data 1", 10, 20, 30)
  .addDataset("Data 2", 34, 22, 14)
  .addLabels("Point 1", "Point 2", "Point 3")
  .setTitle("Quick chart")
  .setGridLinesVisible(false)
  .setBeginAtZero(true)
  .toJson();
```

Since the data types of scatter and bubble charts are a bit more complex, you will have to define
`QuickScatterChartDataset` and `QuickBubbleChartDataset` objects that contain the `x y (r)` data of the datapoints.  
Here's an example with a scatter chart:
```java
new QuickScatterChart()
  .addDatasets("Data 1", new QuickScatterChartDataset()
    .addX(10, 20, 30)
    .addY(30, 20, 10))
  .addDatasets("Data 2", new QuickScatterChartDataset()
    .addX(43, 24, 14)
    .addY(5, 32, 23))
  .addLabels("Point 1", "Point 2", "Point 3")
  .setTitle("Quick chart")
  .setShowLine(true)
  .setPointWidth(5)
  .toJson();
```

## Other useful tips & tricks

- To apply default colors to the chart dataset entries, use `applyDefaultStylePerDatapoint()` or
  `applyDefaultStylePerDataset()` on a data entry depending on whether you want to apply the style for every dataset or
  datapoint:
  ```java
  new ScatterChartData()
    .addDataset(dataset)
    .applyDefaultStylePerDatapoint();
  new ScatterChartData()
    .addDataset(dataset1)
    .addDataset(dataset2)
    .applyDefaultStylePerDataset();
  ```
  You can also apply these color schemes to individual datasets by using the functions with the same names in the
  `ChartColor` class:
  ```java
  ChartColors.applyDefaultStylePerDatapoint(dataset);
  ChartColors.applyDefaultStylePerDataset(dataset);
  ```
  Or by directly using the colors from the `ChartColor` class:
  ```java
  BarChartDataset dataset = new BarChartDataset()
    .setData(12, 32, 8, 45, 27, 23)
    .setLabel("Sample Dataset")
    .setBackgroundColor(ChartColors.BACKGROUNDS)
    .setBorderColor(ChartColors.BORDERS)
    .addBorderWidth(1);
  ```
- You can stack multiple different chart types into one chart by using the `MixedChart`:
  ```java
  BarChartDataset barChartDataset = new BarChartDataset()
    .setData(10, 20, 30, 40)
    .setLabel("Bar Dataset")
    .addBorderWidth(2);

  LineChartDataset lineChartDataset = new LineChartDataset()
    .setData(23, 30, 25, 35)
    .setLabel("Line Dataset");

  MixedChartData mixedChartData = new MixedChartData()
    .addDataset(lineChartDataset, barChartDataset)
    .addLabels("January", "February", "March", "April")
    .applyDefaultStylePerDataset();

  MixedChart mixedChart = new MixedChart()
    .setChartData(mixedChartData);
  ```
- You can connect the data points in a scatter chart by setting the `showLine` property to `true`.
  ```java
  Random random = new Random();
  ScatterChartDataset dataset1 = new ScatterChartDataset()
    .setLabel("Points in time and space p.1")
    .setShowLine(true);
  for (int i = 0; i < 5; i++)
    dataset1.addData(new ScatterChartDatapoint(random.nextInt(100), random.nextInt(100)));
  ```

## Further notes

These are obviously not even half of the features you can use to style and configure your chart.  
Also take a look at the [examples](example.md).