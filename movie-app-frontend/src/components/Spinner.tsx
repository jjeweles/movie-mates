import React from 'react';
import styled, { keyframes } from 'styled-components';

const SpinnerWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
`;

const spin = keyframes`
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
`;

const SpinnerElement = styled.div`
  display: inline-block;
  width: 80px;
  height: 80px;
  border: 8px solid rgba(0, 0, 0, 0.1);
  border-left-color: #ff6600;
  border-radius: 50%;
  animation: ${spin} 1s linear infinite;
`;

const Spinner = () => (
    <SpinnerWrapper>
        <SpinnerElement />
    </SpinnerWrapper>
);

export default Spinner;
