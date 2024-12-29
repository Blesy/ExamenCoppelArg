FROM node:14 AS build

# Set the working directory
WORKDIR /usr/src/app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the Angular application
RUN npm run build --prod

# Stage 2: Serve the application
FROM nginx:alpine

# Copy the built application from the previous stage
COPY --from=build /usr/src/app/dist/my-angular-app /usr/share/nginx/html

# Expose port 4200
EXPOSE 4200

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]