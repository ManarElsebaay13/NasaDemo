
<h1 align="center">
  NasaDemo
</h1>

:point_right: Clean Architecture: MVVM
-----------------
<div align="center">
<img src="https://camo.githubusercontent.com/0ff5a5738b5561398acfa8563660dafbb5a4fa1e844fc171f930f2228c358f0d/68747470733a2f2f6d69726f2e6d656469756d2e636f6d2f6d61782f313430302f312a3375354a6e6d714f4e5234556e7752453674455633512e706e67">
</div>

- Following Clean Architecture.
- MVVM Architecture.
- Repository pattern.
- Use Cases.
- Applying SOLID principles, each class has a single job with separation of concerns by making classes independent
  of each other and communicating with interfaces.
- Using Kotlin-KTS & buildSrc to handle project dependencies.

:point_right: Tech Stack & Libraries:
-----------------

- Navigation component - navigation graph for navigating and replacing screens/fragments
- DataBinding - allows to more easily write code that interacts with views and replaces ```findViewById```.
- ViewModel - UI related data holder, lifecycle aware.
- Kotlin Coroutines - for managing background threads with simplified code and reducing needs for callbacks
- Retrofit2 & OkHttp3 - to make REST requests to the web service integrated.

:point_right: Project Structure:
-----------------

- Tasks contains the following screens :

  

:warning: License:
--------

```
MIT License

Copyright (c) 2022 Manar Elsebaay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
