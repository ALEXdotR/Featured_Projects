set.seed(1)

data <- read_excel("final ver.xlsx")
corr_mat <- cor(data)
print(corr_mat)

train_rate <- 0.8
train_size <- floor(train_rate*nrow(data))
train_ind <- sample(seq_len(nrow(data)), size = train_size)
train_data <- data[train_ind,]
test_data <- data[-train_ind,]

linearMod1 <- lm(`Y insufficient sleep %` ~ `frequent mental distress %`, data=train_data)
print(summary(linearMod1))

plot(train_data$`frequent mental distress %`, train_data$`Y insufficient sleep %`)
lines(train_data$`frequent mental distress %`,linearMod1$fitted.values, col="red")

linearMod2 <- lm(`Y insufficient sleep %` ~ `Q2 household income`, data=train_data)
print(summary(linearMod2))

plot(train_data$`Q2 household income`, train_data$`Y insufficient sleep %`)
lines(train_data$`Q2 household income`,linearMod2$fitted.values, col="red")


linearMod3 <- lm(`Y insufficient sleep %` ~ `Single parent household %`, data=train_data)
print(summary(linearMod3))

plot(train_data$`Single parent household %`, train_data$`Y insufficient sleep %`)
lines(train_data$`Single parent household %`,linearMod3$fitted.values, col="red")

linearMod4 <- lm(`Y insufficient sleep %` ~ `County value of 18 -65`, data=train_data)
print(summary(linearMod4))

plot(train_data$`County value of 18 -65`, train_data$`Y insufficient sleep %`)
lines(train_data$`County value of 18 -65`,linearMod4$fitted.values, col="red")

linearMod5 <- lm(`Y insufficient sleep %` ~ `County value of 65 or older`, data=train_data)
print(summary(linearMod5))

plot(train_data$`County value of 65 or older`, train_data$`Y insufficient sleep %`)
lines(train_data$`County value of 65 or older`,linearMod5$fitted.values, col="red")

prediction1 = predict(linearMod1, newdata=test_data)

plot(test_data$`frequent mental distress %`, test_data$`Y insufficient sleep %`)
lines(test_data$`frequent mental distress %`, prediction1)

library("Metrics")
MAPE1 <- mape(test_data$`Y insufficient sleep %`, prediction1)
print(MAPE1)
RMSE1 <- rmse(test_data$`Y insufficient sleep %`, prediction1)
print(RMSE1)

prediction2 = predict(linearMod2, newdata=test_data)

plot(test_data$`Q2 household income`, test_data$`Y insufficient sleep %`)
lines(test_data$`Q2 household income`, prediction2)

library("Metrics")
MAPE2 <- mape(test_data$`Y insufficient sleep %`, prediction2)
print(MAPE2)
RMSE2 <- rmse(test_data$`Y insufficient sleep %`, prediction2)
print(RMSE2)

prediction3 = predict(linearMod3, newdata=test_data)

plot(test_data$`Single parent household %`, test_data$`Y insufficient sleep %`)
lines(test_data$`Single parent household %`, prediction3)

library("Metrics")
MAPE3 <- mape(test_data$`Y insufficient sleep %`, prediction3)
print(MAPE3)
RMSE3 <- rmse(test_data$`Y insufficient sleep %`, prediction3)
print(RMSE3)

prediction4 = predict(linearMod4, newdata=test_data)

plot(test_data$`County value of 18 -65`, test_data$`Y insufficient sleep %`)
lines(test_data$`County value of 18 -65`, prediction4)

library("Metrics")
MAPE4 <- mape(test_data$`Y insufficient sleep %`, prediction4)
print(MAPE4)
RMSE4 <- rmse(test_data$`Y insufficient sleep %`, prediction4)
print(RMSE4)

prediction5 = predict(linearMod5, newdata=test_data)

plot(test_data$`County value of 65 or older`, test_data$`Y insufficient sleep %`)
lines(test_data$`County value of 65 or older`, prediction5)

library("Metrics")
MAPE5 <- mape(test_data$`Y insufficient sleep %`, prediction5)
print(MAPE5)
RMSE5 <- rmse(test_data$`Y insufficient sleep %`, prediction5)
print(RMSE5)