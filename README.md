<h1 align="center">Quotes Trivia</h1>

**Quotes Trivia** is simple trivia game where you have to pick the notable humans in history that originally said the memorable quote in a multiple-choice challenge. At the end of each game you will get a score based on the number of correct answers you have selected. You can also share you score with others.

> Android sample app to get familiarized with **Navigation Component**

<h2 align="center">App in action</h2>

<p align="center">
  <img src="https://github.com/sbis04/quotes_trivia/raw/master/screenshot/app_anim.gif" alt="App Animation" />
</p>

## Navigation Graph

It manages your app's navigation. It is a resource file that consists of the **destinations** along with the **actions**, which are used for navigating to another destination from the current one.

The **Navigation Graph** of the Quotes Trivia looks like this: 

<p align="center">
  <img src="https://github.com/sbis04/quotes_trivia/raw/master/screenshot/nav_graph_complete.png" alt="Navigation Graph" />
</p>

## Codemagic YAML template

You can use the following `codemagic.yaml` file for generating and uploading the build analysis result to [SonarQube](https://www.sonarqube.org/) using [Codemagic](https://codemagic.io/start/).

```yaml
workflows:
    android-app:
        name: SonarQube Analysis
        environment:
            vars:
                SONAR_TOKEN: Encrypted(...) # enter the encrypted version of your SonarCloud token
                SONAR_PROJECT_KEY: Encrypted(...) # enter the encrypted version of your SonarCloud project key
                SONAR_ORG_KEY: Encrypted(...) # enter the encrypted version of your SonarCloud organization key
                SONAR_PROJECT_VERSION: 1.0.0-cm
        scripts:
            - |
              # Generate debug build
              ./gradlew assembleDebug
            - |
              # Generate and upload code analysis report
              ./gradlew sonarqube \
              -Dsonar.projectKey=$SONAR_PROJECT_KEY \
              -Dsonar.organization=$SONAR_ORG_KEY \
              -Dsonar.host.url=https://sonarcloud.io \
              -Dsonar.login=$SONAR_TOKEN \
              -Dsonar.projectVersion=$SONAR_PROJECT_VERSION
        artifacts:
            - app/build/outputs/**/*.apk
        publishing:
            email:
                recipients:
                    - name@example.com # enter your email
```

## License

Copyright (c) 2020 Souvik Biswas

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