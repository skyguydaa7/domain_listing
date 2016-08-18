<p><span style="font-size:22px;"><strong>Domain App Example</strong></span><br />

<br />

<strong>Description</strong><br />

<br />

&nbsp; This example was build as an exercise and has a pre-defined call to meet the requirements. It&#39;s based on a MVP architecture and separates presentation, domain and data layers for testing and productivity gains.<br />

<br />

&nbsp; Main libraries:</p>

<ul>

<li>Dagger2 - For dependency injection, facilitating tests and flavours.</li>

<li>RXJava - Reactive Java for communication between layers and life cycle control.</li>

<li>Retrofit2 - RestFul Api integration. Retrofit is really helpful when using an API as a datasource, relying on posting, deleting, getting, putting content.</li>

<li>ButterKnife - To avoid the boilerplate of getViewById and keep the code clean.</li>

<li>Picasso - Lazy image loading.</li>

</ul>

<p><br />

<strong>Running tests:</strong><br />

<br />

&nbsp;- gradle runTests in each module. {data - app}<br />

<br />

<strong>Compiling and Installing.</strong><br />

<br />

&nbsp; To compile the app and generate the APK, just clone the project and import in Android Studio.<br />

<br />

<strong> TODO </strong> </br>
<p> - Refactor tests. </p>
<p> - Animations. </p>

