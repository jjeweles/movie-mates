import React from 'react';
import styled, { keyframes } from 'styled-components';

const LoadingWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
`;

const loadingAnimation = keyframes`
  0% {
    width: 0%;
  }
  50% {
    width: 100%;
  }
  100% {
    width: 0%;
  }
`;

const LoadingBarElement = styled.div`
  position: relative;
  background-color: #f3f3f3;
  border-radius: 4px;
  height: 20px;
  width: 200px;
  overflow: hidden;

  &:before {
    content: "";
    position: absolute;
    height: 100%;
    width: 50%;
    background-color: #007bff;
    animation: ${loadingAnimation} 2s linear infinite;
  }
`;

const LoadingBar = () => (
    <LoadingWrapper>
        <LoadingBarElement />
    </LoadingWrapper>
);

export default LoadingBar;
