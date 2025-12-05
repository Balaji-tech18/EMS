# Dockerfile.dev - Node 20 Debian-based (avoids musl/alpine binding issues)
FROM node:20-bullseye-slim

WORKDIR /app

# Install build tools so native modules can compile if needed
RUN apt-get update && apt-get install -y --no-install-recommends \
    build-essential python3 git ca-certificates \
 && rm -rf /var/lib/apt/lists/*

COPY package.json package-lock.json* yarn.lock* ./

# install deps
RUN if [ -f yarn.lock ]; then yarn --frozen-lockfile; \
    elif [ -f package-lock.json ]; then npm ci; \
    else npm install; fi

# copy source
COPY . .

EXPOSE 5173

# start vite dev server reachable from host
CMD ["sh", "-c", "npm run dev -- --host 0.0.0.0 --port 5173"]
