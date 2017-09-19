# pwr-bachelor-microservices

### adding app to heroku
```bash
cd <app_folder>
git init
git add .
git commit -m"first heroku commit"
gir apps:create <app_name>
git push heroku master

heroku open # opens app in browser
heroku logs --tail
```